# 實作範例 - 北美鳥類專家系統

此資料夾包含從CSV原始資料轉換到Prolog專家系統的實際範例檔案。

## 資料流程

```
template_birds_wide.csv → propositions.csv → truth_table.csv → dnf_species.csv → birds.pl
```

## 檔案說明

### 1. template_birds_wide.csv
- **內容**: 18種北美鳥類的原始資料
- **格式**: 寬版CSV，包含23個特徵欄位
- **範例鳥類**: laysan albatross, black footed albatross, fulmar, mallard等

### 2. propositions.csv  
- **內容**: 命題變數定義
- **用途**: 將文字特徵轉換為布林命題變數

### 3. truth_table.csv
- **內容**: 真值表驗證資料
- **格式**: 每個鳥類的所有命題變數值（0或1）
- **用途**: 驗證邏輯一致性、完整性、唯一性
- **欄位**: species_en, bill_hooked, size_large, color_white等布林值

### 4. dnf_species.csv
- **內容**: DNF (Disjunctive Normal Form) 化簡後的規則
- **格式**: 包含english_name, zh_name, order, family, props等欄位
- **用途**: 經過布林代數化簡的中間格式

### 5. birds.pl
- **內容**: 最終的Prolog專家系統規則
- **規則數**: 20條規則，涵蓋18種鳥類
- **格式**: 可直接在SWI-Prolog執行的規則檔

## 注意事項

- 本範例使用**北美鳥類**資料集（18種）
- 與台灣鳥類資料集（ntu_bird）為不同的專案
- aligned_wide.csv屬於台灣鳥類專案，不包含在此範例中

## 執行方式

```prolog
?- consult('birds.pl').
?- bird(X).
```

這將列出所有可識別的鳥類。