package org.projog.expert.ui;

import java.util.HashMap;
import java.util.Map;

/** Simple i18n helper for Chinese UI strings. */
final class Messages {
   private static final Map<String, String> ATTRIBUTES = new HashMap<>();
   private static final Map<String, String> VALUES = new HashMap<>();
   private static final Map<String, String> SPECIES = new HashMap<>();

   static {
      // Attributes (from birds.pl menuask/3)
      ATTRIBUTES.put("nostrils", "鼻孔");
      ATTRIBUTES.put("live", "棲地");
      ATTRIBUTES.put("bill", "喙形");
      ATTRIBUTES.put("size", "大小");
      ATTRIBUTES.put("eats", "食性");
      ATTRIBUTES.put("feet", "足部");
      ATTRIBUTES.put("wings", "翼形");
      ATTRIBUTES.put("neck", "頸部");
      ATTRIBUTES.put("color", "顏色");
      ATTRIBUTES.put("flight", "飛行方式");
      ATTRIBUTES.put("feed", "取食方式");
      ATTRIBUTES.put("head", "頭部");
      ATTRIBUTES.put("tail", "尾巴");
      ATTRIBUTES.put("voice", "叫聲");
      ATTRIBUTES.put("season", "季節");
      ATTRIBUTES.put("cheek", "臉頰");
      ATTRIBUTES.put("flight profile", "飛行姿態");
      ATTRIBUTES.put("throat", "喉部");
      ATTRIBUTES.put("state", "州");
      ATTRIBUTES.put("province", "省");

      // Values (common options shown in UI)
      VALUES.put("external tubular", "外伸管狀");
      VALUES.put("at sea", "海上");
      VALUES.put("flat", "扁平");
      VALUES.put("short", "短");
      VALUES.put("sharp hooked", "尖銳彎曲");
      VALUES.put("hooked", "彎曲");

      VALUES.put("large", "大");
      VALUES.put("plump", "圓胖");
      VALUES.put("medium", "中等");
      VALUES.put("small", "小");

      VALUES.put("birds", "鳥類");
      VALUES.put("insects", "昆蟲");
      VALUES.put("flying insects", "飛行昆蟲");
      VALUES.put("meat", "肉類");

      VALUES.put("curved talons", "彎曲利爪");
      VALUES.put("one long backward toe", "一根長後趾");
      VALUES.put("webbed", "有蹼");

      VALUES.put("broad", "寬廣");
      VALUES.put("long broad", "長而寬");
      VALUES.put("long pointed", "細長尖形");
      VALUES.put("long narrow", "狹長");

      VALUES.put("long", "長");

      VALUES.put("dark", "深色");
      VALUES.put("mottled brown", "斑駁棕色");
      VALUES.put("white", "白色");

      VALUES.put("ponderous", "笨重");
      VALUES.put("powerful", "有力");
      VALUES.put("agile", "敏捷");
      VALUES.put("flap glide", "撲翼-滑翔");

      VALUES.put("scavange", "食腐");
      VALUES.put("on water surface", "水面取食");

      VALUES.put("black", "黑色");
      VALUES.put("green", "綠色");

      VALUES.put("narrow at tip", "末端狹窄");
      VALUES.put("forked", "叉狀");
      VALUES.put("long rusty", "長且鐵鏽色");
      VALUES.put("square", "方形");

      VALUES.put("muffled musical whistle", "悶悶的音樂口哨");
      VALUES.put("loud trumpeting", "響亮號角聲");
      VALUES.put("quack", "呱呱");
      VALUES.put("short whistle", "短促口哨");

      VALUES.put("winter", "冬季");
      VALUES.put("summer", "夏季");

      VALUES.put("v shaped", "V 型");
      // Note: "flat" already mapped (flight profile shares same token)

      // Places
      VALUES.put("massachusetts", "麻薩諸塞");
      VALUES.put("vermont", "佛蒙特");
      VALUES.put("florida", "佛羅里達");
      VALUES.put("mississippi", "密西西比");
      VALUES.put("ontario", "安大略");
      VALUES.put("quebec", "魁北克");

      // Extra option injected by RulesEngine
      VALUES.put("none of the above", "以上皆非");

      // Species names
      SPECIES.put("laysan albatross", "賴桑信天翁");
      SPECIES.put("black footed albatross", "黑足信天翁");
      SPECIES.put("fulmar", "暴風鸌");
      SPECIES.put("whistling swan", "嘯天鵝");
      SPECIES.put("trumpeter swan", "號角天鵝");
      SPECIES.put("canada goose", "加拿大雁");
      SPECIES.put("snow goose", "雪雁");
      SPECIES.put("mallard", "綠頭鴨");
      SPECIES.put("pintail", "針尾鴨");
      SPECIES.put("turkey vulture", "美洲禿鷹");
      SPECIES.put("california condor", "加州神鷹");
      SPECIES.put("sparrow hawk", "美洲紅隼");
      SPECIES.put("peregrine falcon", "遊隼");
      SPECIES.put("great crested flycatcher", "冠霸鶲");
      SPECIES.put("ash throated flycatcher", "灰喉霸鶲");
      SPECIES.put("barn swallow", "家燕");
      SPECIES.put("cliff swallow", "崖沙燕");
      SPECIES.put("purple martin", "紫燕");
   }

   private Messages() {}

   static String attr(String key) {
      return ATTRIBUTES.getOrDefault(key, key);
   }

   static String val(String token) {
      return VALUES.getOrDefault(token, token);
   }

   static String appTitle() {
      return "鳥類專家系統";
   }

   static String question(String attribute) {
      return "請選擇「" + attr(attribute) + "」的值：";
   }

   static String resultPresent(String bird) {
      return "此鳥類為：" + speciesDisplay(bird) + "。";
   }

   static String resultAbsent() {
      return "無法辨識該鳥類。";
   }

   static String reset() {
      return "重新辨識";
   }
   static String speciesDisplay(String english) {
      String zh = SPECIES.get(english);
      return zh != null ? zh + " (" + english + ")" : english;
   }
}
