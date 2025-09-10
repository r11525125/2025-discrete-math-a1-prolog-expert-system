# ntu_bird.csv 欄位說明（精簡版）

本檔描述 `ntu_bird.csv` 欄位用途、資料型態與單位，供課堂或實驗使用。建議將「連續數值」進行離散化（見文末），以利規則化與可解釋性。

- 基本資訊
  - species_en: 英文名（字串）
  - species_zh: 中文名（字串）
  - rule_id: 規則編號（字串/整數；多場域時會有多列）

- 形態 Morphology（單位與型態）
  - body_length_mm_min/max/mid: 體長（mm，數值）
  - bill_length_mm_min/max/mid: 喙長（mm，數值）
  - wing_length_mm_min/max/mid: 翼長（mm，數值）
  - tail_length_mm_min/max/mid: 尾長（mm，數值）
  - tarsus_length_mm_min/max/mid: 跗蹠長（mm，數值）
  - weight_g_min/max/mid: 體重（g，數值）

- 顏色 Colors（羽毛 only）
  - primary_color, secondary_color: 顯示用主/次色（由 12 類旗標推導）
  - color_black/white/light_gray/dark_gray/light_brown/dark_brown/rufous/green/yellow/blue/purple/red: 12 類顏色旗標（0/1）

- 留遷狀態 Migratory status（0/1）
  - Resident, Winter, Summer, Transient, Vagrant, Introduced

- 覓食行為 Foraging behavior（百分比 0–100）
  - Behavior_Sally/Glean/Sweep/Sticky/Peck/Suck/Filter/Dive/Flycatch/Stab/SkyToWater/Probe/Fly

- 食性 Diet（百分比 0–100）
  - Diet_Plankton/Annelid/Mollus/Hexapod/Crustacean/Multipod/Spider/Mammal/Bird/Reptiles/Amphibian/Fish/CarrionTrash/Fruit/Nect/Seed/Leaf

- 覓食棲位 Foraging stratum（百分比 0–100）
  - ForStrat_WatBelowDeep/WatBelowShallow/Watsurf/Mud/Ground/Understory/MidLayer/Canopy/Aerial/Trunk

- 活動與群聚（0/1）
  - ActivityTime_Diurnal, ActivityTime_Nocturnal
  - Flocks_ConspecificsBreedingSeason/ConspecificsNonBreedingSeason/Mixed.speciesNonBreedingSeason

- 棲地與海拔（0/1）
  - Habitat_*: 22 類棲地二元欄位
  - Elevation_Plain/Low/Middle/High

- 領域性與繁殖
  - Territoriality_BreedingSeason: 1–4（對應 A/B/C/D 型）
  - Territoriality_BreedingSeasonType: A/B/C/D（字串）
  - Territoriality_NonBreedingSeason: 0/1
  - BroodParasites, ColonialBreeding: 0/1
  - Nestsite_*（12 欄）/Neststructure_*（8 欄）: 0/1
  - ClutchSizeMean: 平均窩卵數（數值）

- 二型性與生態系服務（0/1）
  - Dimorphism_Size, Dimorphism_Plumage
  - EcosystemServices_Pollination/SeedDispersal/InsectControl/RegulationInvasiveSpecies

- 備註
  - status_notes: 補充說明（字串）
  - campus_spots: 校園常見地點（字串）

## 離散化建議（務必執行於連續/百分比欄）
- 形態連續值（mm/g）
  - 做分箱：small/medium/large（可用分位數或領域知識門檻）
  - 或標準化後再切割（例如 z-score 後切三段）
- 百分比欄（覓食行為/食性/棲位）
  - 二值化：presence=1 若 ≥ 10%（或你指定門檻），否則 0
  - 多級化：low/med/high（如 0–10/10–40/≥40）
- ClutchSizeMean 等其他連續欄位
  - 同樣以分箱或量化分級（例：少/中/多）

離散化可降低規則複雜度、提升可讀性，並有利於布林邏輯或 Prolog 規則的學習與驗證。

