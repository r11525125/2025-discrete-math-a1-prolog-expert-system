# 鳥類專家系統（Java + Prolog）

本專案示範如何以 Java 圖形介面結合 Prolog 規則，實作一個鳥類分類的專家系統。規則採用 Prolog，透過 Projog 整合；UI 與互動則由 Java Swing 實作。

- 規則來源：改編自 Dennis Merritt「Adventure in Prolog」中的 birds 規則範例。
- Prolog 引擎：使用開源專案 [Projog](http://projog.org)。

## 原始來源
- 原始倉庫（上游）：https://github.com/s-webber/prolog-expert-system
- Prolog 引擎：https://projog.org

本分支（作業示範）新增：繁體中文介面、物種中英對照、中文說明文件。

## 環境需求
- Java 8 或以上（JDK）
- 不需安裝 Maven，專案已附 `mvnw/mvnw.cmd` 包裝器（第一次建置需網路下載相依套件）。

## 建置與執行
1. 建置：
   - macOS/Linux：`./mvnw package`
   - Windows：`mvnw.cmd package`
2. 執行：
   - `java -jar target/prolog-expert-system-0.1.0-SNAPSHOT.jar`

啟動後會出現 GUI 視窗，視窗標題為「鳥類專家系統」。系統會依規則提問（如「大小」、「顏色」、「足部」…），請在每個問題下從按鈕中選擇一個答案，最終將顯示辨識結果。

## 規則檔案位置
- Prolog 規則主檔：`src/main/resources/birds.pl`
- Java 端載入方式：`RulesEngine` 使用 `projog.consultResource("birds.pl")` 由 classpath 載入。
- 擴充規則：直接編輯 `birds.pl`，或新增更多 `.pl` 放在 `src/main/resources/`，再於 Java 端額外呼叫 `consultResource("你的檔名.pl")`（或在 `birds.pl` 內用 Prolog 的 `consult/1` 載入）。

## 介面與語言
- 問題與選項：以中文顯示，但內部仍使用英文 token 與 Prolog 規則對應。
- 物種名稱：以「中文（英文）」方式顯示，例如「綠頭鴨 (mallard)」。
- 重新辨識：結果頁按下「重新辨識」可回到提問流程。

## 範例選擇（保證可辨識）
下列為可直接導向特定鳥種的「屬性 → 值」範例。實際提問順序會依規則推理而異，但只要選到這些值，最終即可辨識出來。

- 賴桑信天翁 (laysan albatross)
  - 鼻孔：外伸管狀
  - 棲地：海上
  - 喙形：彎曲
  - 大小：大
  - 翼形：狹長
  - 顏色：白色

- 黑足信天翁 (black footed albatross)
  - 鼻孔：外伸管狀
  - 棲地：海上
  - 喙形：彎曲
  - 大小：大
  - 翼形：狹長
  - 顏色：深色

- 暴風鸌 (fulmar)
  - 鼻孔：外伸管狀
  - 棲地：海上
  - 喙形：彎曲
  - 大小：中等
  - 飛行方式：撲翼-滑翔

- 嘯天鵝 (whistling swan)
  - 足部：有蹼
  - 喙形：扁平
  - 頸部：長
  - 顏色：白色
  - 飛行方式：笨重
  - 叫聲：悶悶的音樂口哨

- 號角天鵝 (trumpeter swan)
  - 足部：有蹼
  - 喙形：扁平
  - 頸部：長
  - 顏色：白色
  - 飛行方式：笨重
  - 叫聲：響亮號角聲

- 加拿大雁 (canada goose) — 冬季／美國
  - 足部：有蹼
  - 喙形：扁平
  - 大小：圓胖
  - 飛行方式：有力
  - 季節：冬季
  - 州：佛蒙特
  - 頭部：黑色
  - 臉頰：白色

- 加拿大雁 (canada goose) — 夏季／加拿大
  - 足部：有蹼
  - 喙形：扁平
  - 大小：圓胖
  - 飛行方式：有力
  - 季節：夏季
  - 省：魁北克
  - 頭部：黑色
  - 臉頰：白色

- 雪雁 (snow goose)
  - 足部：有蹼
  - 喙形：扁平
  - 大小：圓胖
  - 飛行方式：有力
  - 顏色：白色

- 綠頭鴨 (mallard) — 雄
  - 足部：有蹼
  - 喙形：扁平
  - 取食方式：水面取食
  - 飛行方式：敏捷
  - 叫聲：呱呱
  - 頭部：綠色

- 綠頭鴨 (mallard) — 雌
  - 足部：有蹼
  - 喙形：扁平
  - 取食方式：水面取食
  - 飛行方式：敏捷
  - 叫聲：呱呱
  - 顏色：斑駁棕色

- 針尾鴨 (pintail)
  - 足部：有蹼
  - 喙形：扁平
  - 取食方式：水面取食
  - 飛行方式：敏捷
  - 叫聲：短促口哨

- 美洲禿鷹 (turkey vulture)
  - 足部：彎曲利爪
  - 喙形：尖銳彎曲
  - 食性：肉類
  - 取食方式：食腐
  - 翼形：寬廣
  - 飛行姿態：V 型

- 加州神鷹 (california condor)
  - 足部：彎曲利爪
  - 喙形：尖銳彎曲
  - 食性：肉類
  - 取食方式：食腐
  - 翼形：寬廣
  - 飛行姿態：扁平

- 美洲紅隼 (sparrow hawk)
  - 足部：彎曲利爪
  - 喙形：尖銳彎曲
  - 翼形：細長尖形
  - 頭部：大
  - 尾巴：末端狹窄
  - 食性：昆蟲

- 游隼 (peregrine falcon)
  - 足部：彎曲利爪
  - 喙形：尖銳彎曲
  - 翼形：細長尖形
  - 頭部：大
  - 尾巴：末端狹窄
  - 食性：鳥類

- 冠霸鶲 (great crested flycatcher)
  - 足部：一根長後趾
  - 喙形：扁平
  - 食性：飛行昆蟲
  - 尾巴：長且鐵鏽色

- 灰喉霸鶲 (ash throated flycatcher)
  - 足部：一根長後趾
  - 喙形：扁平
  - 食性：飛行昆蟲
  - 喉部：白色

- 家燕 (barn swallow)
  - 足部：一根長後趾
  - 翼形：細長尖形
  - 喙形：短
  - 尾巴：叉狀

- 崖沙燕 (cliff swallow)
  - 足部：一根長後趾
  - 翼形：細長尖形
  - 喙形：短
  - 尾巴：方形

- 紫燕 (purple martin)
  - 足部：一根長後趾
  - 翼形：細長尖形
  - 喙形：短
  - 顏色：深色

> 提示：請盡量避免頻繁選「以上皆非」，那會使規則無法滿足，導致「無法辨識」。

## 常見問題（FAQ）
- 執行後只有英文？
  - 請使用本專案加入的最新程式碼（UI 已本地化）。若你改動過 UI 程式，請參考 `org.projog.expert.ui.Messages` 的對照表。
- 總是顯示「無法辨識」？
  - 代表你的回答組合未能滿足任何物種規則。可先依照上方範例嘗試，或在 `birds.pl` 擴充規則。
- 無法顯示 GUI？
  - 請在有圖形介面的桌面環境執行，或在本機直接運行 JAR。
- 想新增更多地區或選項？
  - `birds.pl` 中 `state/1`、`province/1`、`region/1` 的實作是簡化版本，可自行擴充更多地區。

## 授權
本專案沿用上游原始授權（詳見原倉庫）。
