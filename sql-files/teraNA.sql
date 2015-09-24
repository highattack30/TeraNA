
CREATE TABLE IF NOT EXISTS `accounts` (
  `AccountId` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(32) NOT NULL DEFAULT '',
  `password` varchar(256) DEFAULT '',
  `email` varchar(45) DEFAULT 'null@null',
  `access_level` smallint(6) NOT NULL DEFAULT '0',
  `end_pay` bigint(15) NOT NULL DEFAULT '0',
  `end_block` bigint(15) NOT NULL DEFAULT '0',
  `last_ip` varchar(15) NOT NULL DEFAULT '',
  `allow_ips` varchar(255) NOT NULL DEFAULT '*',
  `comments` varchar(255) NOT NULL DEFAULT '',
  `LastOnlineUtc` bigint(64) NOT NULL DEFAULT '0',
  `EmailVerify` varchar(256) NOT NULL DEFAULT 'true',
  `PasswordRecovery` varchar(128) DEFAULT NULL,
  `Coins` int(11) NOT NULL DEFAULT '0',
  `Ip` varchar(64) NOT NULL DEFAULT '0.0.0.0',
  `isFounder` int(1) NOT NULL DEFAULT '0',
  `Membership` int(1) NOT NULL DEFAULT '0',
  `isGM` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`AccountId`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`),
  KEY `access_level` (`access_level`)
) ENGINE=MyISAM ;


CREATE TABLE IF NOT EXISTS `boss_spawn` (
  `npc_id` int(10) unsigned NOT NULL DEFAULT '0',
  `npc_type` int(10) unsigned NOT NULL DEFAULT '0',
  `spawn` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`npc_id`,`npc_type`)
) ENGINE=MyISAM ;


CREATE TABLE IF NOT EXISTS `characters` (
  `account_name` varchar(45) NOT NULL DEFAULT '',
  `object_id` int(11) NOT NULL DEFAULT '0',
  `class_id` tinyint(3) NOT NULL DEFAULT '0',
  `race_id` tinyint(1) NOT NULL DEFAULT '0',
  `sex` tinyint(1) NOT NULL DEFAULT '0',
  `char_name` varchar(35) NOT NULL DEFAULT '',
  `heading` int(15) NOT NULL DEFAULT '0',
  `online_time` bigint(15) NOT NULL DEFAULT '0',
  `create_time` bigint(15) NOT NULL DEFAULT '0',
  `end_ban` bigint(15) NOT NULL DEFAULT '0',
  `end_chat_ban` bigint(15) NOT NULL DEFAULT '0',
  `title` varchar(16) NOT NULL DEFAULT '',
  `guild_id` int(15) NOT NULL DEFAULT '0' ,
  `access_level` tinyint(4) NOT NULL DEFAULT '0',
  `level` tinyint(3) NOT NULL DEFAULT '0',
  `exp` bigint(15) NOT NULL DEFAULT '0',
  `hp` int(11) NOT NULL DEFAULT '0',
  `mp` int(11) NOT NULL DEFAULT '0',
  `x` double(11,2) DEFAULT '0.00',
  `y` double(11,2) DEFAULT '0.00',
  `z` double(11,2) DEFAULT '0.00',
  `heart` smallint(3) NOT NULL DEFAULT '0',
  `attack_counter` tinyint(3) NOT NULL DEFAULT '0',
  `pvp_count` int(11) NOT NULL DEFAULT '0',
  `pve_count` int(11) NOT NULL DEFAULT '0',
  `guild_rank` tinyint(3) NOT NULL DEFAULT '0',
  `zone_id` int(10) unsigned NOT NULL DEFAULT '0',
  `guild_note` varchar(35) NOT NULL DEFAULT '',
  `karma` int(10) unsigned NOT NULL DEFAULT '0',
  `collect_mining` int(10) unsigned NOT NULL DEFAULT '1' ,
  `collect_plant` int(10) unsigned NOT NULL DEFAULT '1' ,
  `collect_energy` int(10) unsigned NOT NULL DEFAULT '1' ,
  `last_online` int(10) unsigned NOT NULL DEFAULT '0' ,
  `continent_id` smallint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`),
  UNIQUE KEY `char_name` (`char_name`),
  KEY `account_name` (`account_name`),
  KEY `guild` (`guild_id`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `character_appearances` (
  `object_id` int(10) unsigned NOT NULL DEFAULT '0',
  `face_color` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `face_skin` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `adorments_skin` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `features_skin` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `features_color` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `voice` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bone_structure_brow` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bone_structure_cheekbones` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bone_structure_jaw` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bone_structure_jaw_jut` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ears_rotation` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ears_extension` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ears_trim` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ears_size` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_width` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_height` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_separation` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_angle` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_inner_brow` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_outer_brow` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_extension` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_size` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_bridge` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_nostril_width` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_tip_width` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_tip` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_nostril_flare` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mouth_pucker` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mouth_position` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mouth_width` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mouth_lip_thickness` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mouse_corners` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `eyes_shape` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `nose_bend` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bone_structure_jaw_width` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mouth_gape` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `character_faces` (
  `objectId` int(11) NOT NULL DEFAULT '0',
  `faceColor` int(10) NOT NULL DEFAULT '0',
  `hairColor` int(10) NOT NULL DEFAULT '0',
  `eyebrowsFirstVal` int(10) NOT NULL DEFAULT '0',
  `eyebrowsSecondVal` int(10) NOT NULL DEFAULT '0',
  `eyebrowsThridVal` int(10) NOT NULL DEFAULT '0',
  `eyeFirstVal` int(10) NOT NULL DEFAULT '0',
  `eyeSecondVal` int(10) NOT NULL DEFAULT '0',
  `eyeThridVal` int(10) NOT NULL DEFAULT '0',
  `eyePosVertical` int(10) NOT NULL DEFAULT '0',
  `eyeWidth` int(10) NOT NULL DEFAULT '0',
  `eyeHeight` int(10) NOT NULL DEFAULT '0',
  `chin` int(10) NOT NULL DEFAULT '0',
  `cheekbonePos` int(10) NOT NULL DEFAULT '0',
  `earsFirstVal` int(10) NOT NULL DEFAULT '0',
  `earsSecondVal` int(10) NOT NULL DEFAULT '0',
  `earsThridVal` int(10) NOT NULL DEFAULT '0',
  `earsFourthVal` int(10) NOT NULL DEFAULT '0',
  `noseFirstVal` int(10) NOT NULL DEFAULT '0',
  `noseSecondVal` int(10) NOT NULL DEFAULT '0',
  `noseThridVal` int(10) NOT NULL DEFAULT '0',
  `noseFourthVal` int(10) NOT NULL DEFAULT '0',
  `noseFifthVal` int(10) NOT NULL DEFAULT '0',
  `lipsFirstVal` int(10) NOT NULL DEFAULT '0',
  `lipsSecondVal` int(10) NOT NULL DEFAULT '0',
  `lipsThridVal` int(10) NOT NULL DEFAULT '0',
  `lipsFourthVal` int(10) NOT NULL DEFAULT '0',
  `lipsFifthVal` int(10) NOT NULL DEFAULT '0',
  `lipsSixthVal` int(10) NOT NULL DEFAULT '0',
  `cheeks` int(10) NOT NULL DEFAULT '0',
  `bridgeFirstVal` int(10) NOT NULL DEFAULT '0',
  `bridgeSecondVal` int(10) NOT NULL DEFAULT '0',
  `bridgeThridVal` int(10) NOT NULL DEFAULT '0',
  `temp1` int(10) NOT NULL DEFAULT '0',
  `temp2` int(10) NOT NULL DEFAULT '0',
  `temp3` int(10) NOT NULL DEFAULT '0',
  `temp4` int(10) NOT NULL DEFAULT '0',
  `temp5` int(10) NOT NULL DEFAULT '0',
  `temp6` int(10) NOT NULL DEFAULT '0',
  `temp7` int(10) NOT NULL DEFAULT '0',
  `temp8` int(10) NOT NULL DEFAULT '0',
  `temp9` int(10) NOT NULL DEFAULT '0',
  `temp10` int(10) NOT NULL DEFAULT '0',
  `temp11` int(10) NOT NULL DEFAULT '0',
  `temp12` int(10) NOT NULL DEFAULT '0',
  `temp13` int(10) NOT NULL DEFAULT '0',
  `temp14` int(10) NOT NULL DEFAULT '0',
  `temp15` int(10) NOT NULL DEFAULT '0',
  `temp16` int(10) NOT NULL DEFAULT '0',
  `temp17` int(10) NOT NULL DEFAULT '0',
  `temp18` int(10) NOT NULL DEFAULT '0',
  `temp19` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`objectId`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `character_friends` (
  `object_id` int(10) unsigned NOT NULL DEFAULT '0',
  `friend_id` int(10) unsigned NOT NULL DEFAULT '0',
  `friend_note` varchar(45) NOT NULL ,
  PRIMARY KEY (`object_id`,`friend_id`),
  KEY `select` (`object_id`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `character_hotkey` (
  `object_id` int(11) NOT NULL DEFAULT '0',
  `data` blob,
  PRIMARY KEY (`object_id`)
) ENGINE=MyISAM;


CREATE TABLE IF NOT EXISTS `character_inventors` (
  `owner_id` int(11) unsigned NOT NULL DEFAULT '0',
  `id` int(11) unsigned NOT NULL DEFAULT '0',
  `level` smallint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`owner_id`,`id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_presets_2` (
  `objectId` int(11) NOT NULL DEFAULT '0',
  `temp1` int(10) NOT NULL DEFAULT '0',
  `temp2` int(10) NOT NULL DEFAULT '0',
  `temp3` int(10) NOT NULL DEFAULT '0',
  `temp4` int(10) NOT NULL DEFAULT '0',
  `temp5` int(10) NOT NULL DEFAULT '0',
  `temp6` int(10) NOT NULL DEFAULT '0',
  `temp7` int(10) NOT NULL DEFAULT '0',
  `temp8` int(10) NOT NULL DEFAULT '0',
  `temp9` int(10) NOT NULL DEFAULT '0',
  `temp10` int(10) NOT NULL DEFAULT '0',
  `temp11` int(10) NOT NULL DEFAULT '0',
  `temp12` int(10) NOT NULL DEFAULT '0',
  `temp13` int(10) NOT NULL DEFAULT '0',
  `temp14` int(10) NOT NULL DEFAULT '0',
  `temp15` int(10) NOT NULL DEFAULT '0',
  `temp16` int(10) NOT NULL DEFAULT '0',
  `temp17` int(10) NOT NULL DEFAULT '0',
  `temp18` int(10) NOT NULL DEFAULT '0',
  `temp19` int(10) NOT NULL DEFAULT '0',
  `temp20` int(10) NOT NULL DEFAULT '0',
  `temp21` int(10) NOT NULL DEFAULT '0',
  `temp22` int(10) NOT NULL DEFAULT '0',
  `temp23` int(10) NOT NULL DEFAULT '0',
  `temp24` int(10) NOT NULL DEFAULT '0',
  `temp25` int(10) NOT NULL DEFAULT '0',
  `temp26` int(10) NOT NULL DEFAULT '0',
  `temp27` int(10) NOT NULL DEFAULT '0',
  `temp28` int(10) NOT NULL DEFAULT '0',
  `temp29` int(10) NOT NULL DEFAULT '0',
  `temp30` int(10) NOT NULL DEFAULT '0',
  `temp31` int(10) NOT NULL DEFAULT '0',
  `temp32` int(10) NOT NULL DEFAULT '0',
  `temp33` int(10) NOT NULL DEFAULT '0',
  `temp34` int(10) NOT NULL DEFAULT '0',
  `temp35` int(10) NOT NULL DEFAULT '0',
  `temp36` int(10) NOT NULL DEFAULT '0',
  `temp37` int(10) NOT NULL DEFAULT '0',
  `temp38` int(10) NOT NULL DEFAULT '0',
  `temp39` int(10) NOT NULL DEFAULT '0',
  `temp40` int(10) NOT NULL DEFAULT '0',
  `temp41` int(10) NOT NULL DEFAULT '0',
  `temp42` int(10) NOT NULL DEFAULT '0',
  `temp43` int(10) NOT NULL DEFAULT '0',
  `temp44` int(10) NOT NULL DEFAULT '0',
  `temp45` int(10) NOT NULL DEFAULT '0',
  `temp46` int(10) NOT NULL DEFAULT '0',
  `temp47` int(10) NOT NULL DEFAULT '0',
  `temp48` int(10) NOT NULL DEFAULT '0',
  `temp49` int(10) NOT NULL DEFAULT '0',
  `temp50` int(10) NOT NULL DEFAULT '0',
  `temp51` int(10) NOT NULL DEFAULT '0',
  `temp52` int(10) NOT NULL DEFAULT '0',
  `temp53` int(10) NOT NULL DEFAULT '0',
  `temp54` int(10) NOT NULL DEFAULT '0',
  `temp55` int(10) NOT NULL DEFAULT '0',
  `temp56` int(10) NOT NULL DEFAULT '0',
  `temp57` int(10) NOT NULL DEFAULT '0',
  `temp58` int(10) NOT NULL DEFAULT '0',
  `temp59` int(10) NOT NULL DEFAULT '0',
  `temp60` int(10) NOT NULL DEFAULT '0',
  `temp61` int(10) NOT NULL DEFAULT '0',
  `temp62` int(10) NOT NULL DEFAULT '0',
  `temp63` int(10) NOT NULL DEFAULT '0',
  `temp64` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`objectId`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_quests` (
  `object_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quest_id` int(10) unsigned NOT NULL DEFAULT '0' ,
  `state` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `date` bigint(20) unsigned NOT NULL DEFAULT '0',
  `panel_state` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`,`quest_id`)
) ENGINE=MyISAM ;





CREATE TABLE IF NOT EXISTS `character_quest_vars` (
  `object_id` int(10) unsigned NOT NULL,
  `quest_id` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(45) binary NOT NULL DEFAULT '0',
  `value` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`,`quest_id`,`name`),
  KEY `key_id` (`quest_id`,`object_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_save_effects` (
  `object_id` int(11) NOT NULL DEFAULT '0',
  `class_id` tinyint(3) NOT NULL DEFAULT '0',
  `skill_id` int(11) NOT NULL DEFAULT '0',
  `effect_order` tinyint(3) NOT NULL DEFAULT '0',
  `count` int(11) NOT NULL DEFAULT '0',
  `duration` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`,`class_id`,`skill_id`,`effect_order`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_settings` (
  `object_id` int(11) NOT NULL DEFAULT '0',
  `data` blob,
  PRIMARY KEY (`object_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_skills` (
  `object_id` int(11) NOT NULL DEFAULT '0',
  `class_id` tinyint(3) NOT NULL DEFAULT '0',
  `skill_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`,`class_id`,`skill_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_skill_reuses` (
  `object_id` int(11) NOT NULL DEFAULT '0',
  `skill_id` int(11) NOT NULL DEFAULT '0',
  `item_id` int(11) NOT NULL DEFAULT '0',
  `end_time` bigint(110) NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`,`skill_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_territories` (
  `object_id` int(10) unsigned NOT NULL DEFAULT '0',
  `territory_id` int(10) unsigned NOT NULL DEFAULT '0',
  UNIQUE KEY `key_territory` (`territory_id`,`object_id`),
  KEY `key_player` (`object_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `character_variables` (
  `object_id` int(10) unsigned NOT NULL DEFAULT '0',
  `var_name` varchar(45) NOT NULL DEFAULT '',
  `var_value` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`object_id`,`var_name`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `guilds` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `level` smallint(6) NOT NULL DEFAULT '0',
  `icon` blob,
  `icon_name` varchar(45) binary DEFAULT NULL,
  `message` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `guild_ranks` (
  `guild_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rank_name` varchar(45) binary NOT NULL,
  `order` tinyint(3) unsigned NOT NULL ,
  `law` tinyint(3) unsigned NOT NULL,
  KEY `guild_id` (`guild_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `items` (
  `object_id` int(10) unsigned NOT NULL DEFAULT '0',
  `owner_id` int(10) unsigned NOT NULL DEFAULT '0',
  `owner_name` varchar(45) NOT NULL DEFAULT '',
  `item_id` int(10) unsigned NOT NULL DEFAULT '0',
  `item_count` bigint(20) unsigned NOT NULL DEFAULT '0',
  `enchant_level` smallint(5) NOT NULL DEFAULT '0',
  `bonus_id` int(10) NOT NULL DEFAULT '0',
  `autor` varchar(255) NOT NULL DEFAULT '',
  `location` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `index` smallint(6) NOT NULL DEFAULT '0',
  `has_crystal` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_id`),
  KEY `key_owner_id` (`owner_id`)
) ENGINE=MyISAM PACK_KEYS=1;





CREATE TABLE IF NOT EXISTS `region_status` (
  `region_id` int(10) unsigned NOT NULL DEFAULT '0',
  `owner_id` int(10) unsigned NOT NULL DEFAULT '0',
  `state` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`region_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `region_war_register` (
  `region_id` int(10) unsigned NOT NULL DEFAULT '0',
  `guild_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`region_id`,`guild_id`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `server_variables` (
  `var_name` varchar(45) NOT NULL DEFAULT '',
  `var_value` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`var_name`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `skill_learns` (
  `classId` tinyint(3) NOT NULL DEFAULT '0',
  `skillId` int(11) NOT NULL DEFAULT '0',
  `minLevel` smallint(6) NOT NULL DEFAULT '0',
  `price` int(11) NOT NULL DEFAULT '0',
  `replaceId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`classId`,`skillId`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `wait_items` (
  `order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emptor` varchar(45) NOT NULL,
  `char_name` varchar(45) NOT NULL,
  `item_id` int(10) unsigned NOT NULL DEFAULT '0',
  `item_count` int(10) unsigned NOT NULL DEFAULT '1',
  `enchant_level` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`order`,`char_name`,`item_id`,`item_count`),
  KEY `name_key` (`char_name`),
  KEY `order_key` (`order`)
) ENGINE=MyISAM;





CREATE TABLE IF NOT EXISTS `wait_skills` (
  `order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `char_name` varchar(45) NOT NULL,
  `skill_id` int(10) unsigned NOT NULL,
  `skill_class` int(10) NOT NULL,
  PRIMARY KEY (`order`),
  KEY `name_key` (`char_name`)
) ENGINE=MyISAM;


