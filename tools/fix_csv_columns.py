#!/usr/bin/env python3
import sys
from pathlib import Path

def fix_csv(path: Path):
    txt = path.read_text(encoding='utf-8').splitlines()
    if not txt:
        return
    header = txt[0]
    target = header.count(',') + 1
    out = [header]
    for i, line in enumerate(txt[1:], start=2):
        # naive split (file contains no quoted commas)
        parts = [p.strip() for p in line.split(',')]
        if len(parts) < target:
            parts.extend([''] * (target - len(parts)))
        elif len(parts) > target:
            # keep as-is (should not happen for this file)
            parts = parts[:target]
        out.append(','.join(parts))
    path.write_text('\n'.join(out) + '\n', encoding='utf-8')

if __name__ == '__main__':
    p = Path(sys.argv[1]) if len(sys.argv) > 1 else None
    if not p or not p.exists():
        print('Usage: fix_csv_columns.py <csv_path>'); sys.exit(1)
    fix_csv(p)
    print(f'Fixed columns: {p}')

