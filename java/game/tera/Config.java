package tera;

import java.io.File;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rlib.geoengine.GeoConfig;
import rlib.logging.Loggers;
import rlib.util.Files;
import rlib.util.Strings;
import rlib.util.Util;
import rlib.util.VarTable;
import rlib.util.array.Arrays;
import tera.gameserver.document.DocumentConfig;

import com.jolbox.bonecp.BoneCPConfig;

/**
 * ÐšÐ¾Ð½Ñ„Ð¸Ð³ Ñ�ÐµÑ€Ð²ÐµÑ€Ð°
 * 
 * @author Ronn Mod Evestu
 * @created 11.03.2012
 */
public final class Config {

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ð¾Ð²
	 * ----------------------------------
	 */

	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð¿Ñ€Ð°Ð² Ð´Ð»Ñ� Ð²Ñ…Ð¾Ð´Ð° Ð½Ð° Ñ�ÐµÑ€Ð²ÐµÑ€ */
	public static int ACCOUNT_MIN_ACCESS_LEVEL;

	/** Ñ€ÐµÐ¹Ñ‚ Ð±Ð°Ð·Ð¾Ð²Ñ‹Ñ… Ñ€ÐµÐ¹Ñ‚Ð¾Ð² Ð¿Ñ€Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ð¾Ð¼ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ðµ */
	public static float ACCOUNT_PREMIUM_EXP_RATE;
	/** Ñ€ÐµÐ¹Ñ‚ Ð±Ð°Ð·Ð¾Ð²Ñ‹Ñ… Ñ€ÐµÐ¹Ñ‚Ð¾Ð² Ð¿Ñ€Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ð¾Ð¼ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ðµ */
	public static float ACCOUNT_PREMIUM_MONEY_RATE;
	/** Ñ€ÐµÐ¹Ñ‚ Ð±Ð°Ð·Ð¾Ð²Ñ‹Ñ… Ñ€ÐµÐ¹Ñ‚Ð¾Ð² Ð¿Ñ€Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ð¾Ð¼ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ðµ */
	public static float ACCOUNT_PREMIUM_DROP_RATE;
	/** Ñ€ÐµÐ¹Ñ‚ Ð±Ð°Ð·Ð¾Ð²Ñ‹Ñ… Ñ€ÐµÐ¹Ñ‚Ð¾Ð² Ð¿Ñ€Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ð¾Ð¼ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ðµ */
	public static float ACCOUNT_PREMIUM_QUEST_RATE;

	/** Ð²ÐºÐ»ÑŽÑ‡ÐµÐ½Ð¾ Ð»Ð¸ Ð°Ð²Ñ‚Ð¾Ñ�Ð¾Ð·Ð´Ð°Ð½Ð¸Ðµ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ð¾Ð² Ð¿Ñ€Ð¸ Ð²Ñ…Ð¾Ð´Ðµ Ð² Ð¸Ð³Ñ€Ñƒ */
	public static boolean ACCOUNT_AUTO_CREATE;
	/** Ð¼Ð¾Ð³ÑƒÑ‚ Ð»Ð¸ Ð²Ñ…Ð¾Ð´Ð¸Ñ‚ÑŒ Ñ‚Ð¾Ð»ÑŒÐºÐ¾ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ñ‹Ðµ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ñ‹ */
	public static boolean ACCOUNT_ONLY_PAID;
	/** Ð¸Ð¼ÐµÑŽÑ‚ Ð»Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ñ‹Ðµ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ñ‹ Ð±Ð¾Ð½ÑƒÑ�Ðº Ñ�ÐºÑ�Ð¿Ñ‹ */
	public static boolean ACCOUNT_PREMIUM_EXP;
	/** Ð¸Ð¼ÐµÑŽÑ‚ Ð»Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ñ‹Ðµ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ñ‹ Ð±Ð¾Ð½ÑƒÑ� Ð´ÐµÐ½ÐµÐ³ */
	public static boolean ACCOUNT_PREMIUM_MONEY;
	/** Ð¸Ð¼ÐµÑŽÑ‚ Ð»Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ñ‹Ðµ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ñ‹ Ð±Ð¾Ð½ÑƒÑ� Ð´Ñ€Ð¾Ð¿Ð° */
	public static boolean ACCOUNT_PREMIUM_DROP;
	/** Ð¸Ð¼ÐµÑŽÑ‚ Ð»Ð¸ Ð¿Ñ€Ð¾Ð¿Ð»Ð°Ñ‡ÐµÐ½Ð½Ñ‹Ðµ Ð°ÐºÐºÐ°ÑƒÐ½Ñ‚Ñ‹ Ð±Ð¾Ð½ÑƒÑ� Ð´Ñ€Ð¾Ð¿Ð° */
	public static boolean ACCOUNT_PREMIUM_QUEST;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ñ�ÐµÑ€Ð²ÐµÑ€Ð°
	 * ----------------------------------
	 */

	/** Ð´Ð¾Ð¿ÑƒÑ�Ñ‚Ð¸Ð¼Ñ‹Ðµ Ð½Ð¸ÐºÐ¸ Ð½Ð° Ñ�ÐµÑ€Ð²ÐµÑ€Ðµ */
	public static String SERVER_NAME_TEMPLATE;
	/** Ð²ÐµÑ€Ñ�Ð¸Ñ� Ñ�Ð±Ð¾Ñ€ÐºÐ¸ Ñ�ÐµÑ€Ð²ÐµÑ€Ð° */
	public static String SERVER_VERSION;
	/** Ð°Ð´Ñ€ÐµÑ�Ñ� Ð²Ñ‹Ð²Ð¾Ð´Ð° Ð² Ñ„Ð°Ð¸Ð» Ð¾Ð½Ð»Ð°Ð¹Ð½Ð° Ñ�ÐµÑ€Ð²ÐµÑ€Ð° */
	public static String SERVER_ONLINE_FILE;

	/** Ñ�Ð°Ð± Ð¸Ð´ Ð¸Ð³Ñ€Ð¾ÐºÐ° */
	public static int SERVER_PLAYER_SUB_ID;
	/** Ñ�Ð°Ð± Ð¸Ð´ Ð½Ð¿Ñ� */
	public static int SERVER_NPC_SUB_ID;
	/** Ñ�Ð°Ð± Ð¸Ð´ Ð¸Ñ‚ÐµÐ¼Ð° */
	public static int SERVER_ITEM_SUB_ID;
	/** Ñ�Ð°Ð± Ð¸Ð´ Ð²Ñ‹Ñ�Ñ‚Ñ€ÐµÐ»Ð° */
	public static int SERVER_SHOT_SUB_ID;
	/** Ñ�Ð°Ð± Ð¸Ð´ Ð¾Ð±ÑŠÐµÐºÑ‚Ð° */
	public static int SERVER_OBJECT_SUB_ID;
	/** Ñ�Ð°Ð± Ð¸Ð´ Ð»Ð¾Ð²ÑƒÑˆÐµÐº */
	public static int SERVER_TRAP_SUB_ID;
	/** Ñ�Ð°Ð± Ð¸Ð´ Ð»Ð¾Ð²ÑƒÑˆÐµÐº */
	public static int SERVER_RESOURSE_SUB_ID;
	/** Ð¿Ð¾Ñ€Ñ‚ Ñ�ÐµÑ€Ð²ÐµÑ€Ð° */
	public static int SERVER_PORT;

	/** Ð¼Ð½Ð¾Ð¶Ð¸Ñ‚ÐµÐ»ÑŒ Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼Ð¾Ð³Ð¾ Ð¾Ð¿Ñ‹Ñ‚Ð° */
	public static float SERVER_RATE_EXP;
	/** Ð¼Ð½Ð¾Ð¶Ð¸Ñ‚ÐµÐ»ÑŒ Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼Ð¾Ð³Ð¾ Ð¾Ð¿Ñ‹Ñ‚Ð° Ð² Ð³Ñ€ÑƒÐ¿Ð¿Ðµ */
	public static float SERVER_PARTY_RATE_EXP;
	/** Ð¼Ð½Ð¾Ð¶Ð¸Ñ‚ÐµÐ»ÑŒ Ð´Ñ€Ð¾Ð¿Ð½ÑƒÑ‚Ñ‹Ñ… Ð´ÐµÐ½ÐµÐ³ */
	public static float SERVER_RATE_MONEY;
	/** Ð¼Ð½Ð¾Ð¶Ð¸Ñ‚ÐµÐ»ÑŒ Ð²Ñ‹Ð¿Ð°Ð´Ð°ÑŽÑ‰ÐµÐ³Ð¾ Ð´Ñ€Ð¾Ð¿Ð° */
	public static float SERVER_RATE_DROP_ITEM;
	/** Ð¼Ð½Ð¾Ð¶Ð¸Ñ‚ÐµÐ»ÑŒ Ð½Ð°Ð³Ñ€Ð°Ð´Ñ‹ Ð·Ð° ÐºÐ²ÐµÑ�Ñ‚Ñ‹ */
	public static float SERVER_RATE_QUEST_REWARD;
	/** % Ð±Ð¾Ð½ÑƒÑ�Ð° Ðº Ð¾Ð½Ð»Ð°Ð¹Ð½Ñƒ Ñ�ÐµÑ€Ð²ÐµÑ€Ð° */
	public static float SERVER_ONLINE_FAKE;

	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð¾Ð¿ÐºÐ¾Ð´Ñ‹ Ñ�Ð½Ð¸Ñ„ÐµÑ€Ð° */
	public static boolean SERVER_USE_SNIFFER_OPCODE;
	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ€ÐµÐ°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð½Ð´Ð¾Ð¼Ð¸Ð½Ð°Ð¹Ð·ÐµÑ€ Ð´Ð»Ñ� Ð´Ñ€Ð¾Ð¿Ð° */
	public static boolean SERVER_DROP_REAL_RANDOM;
	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ€ÐµÐ°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð½Ð´Ð¾Ð¼Ð¸Ð½Ð°Ð¹Ð·ÐµÑ€ Ð´Ð»Ñ� ÐºÑ€Ð¸Ñ‚Ð¾Ð² */
	public static boolean SERVER_CRIT_REAL_RANDOM;
	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ€ÐµÐ°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð½Ð´Ð¾Ð¼Ð¸Ð½Ð°Ð¹Ð·ÐµÑ€ Ð´Ð»Ñ� Ñ�Ñ„Ñ„ÐµÐºÑ‚Ð¾Ð² */
	public static boolean SERVER_EFFECT_REAL_RANDOM;
	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ€ÐµÐ°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð½Ð´Ð¾Ð¼Ð¸Ð½Ð°Ð¹Ð·ÐµÑ€ Ð´Ð»Ñ� Ñ„ÑƒÐ½ÐºÑ†Ð¸Ð¹ */
	public static boolean SERVER_FUNC_REAL_RANDOM;
	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ€ÐµÐ°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð½Ð´Ð¾Ð¼Ð¸Ð½Ð°Ð¹Ð·ÐµÑ€ Ð´Ð»Ñ� Ð´Ñ�Ð¼Ð°Ð³Ð° */
	public static boolean SERVER_DAMAGE_REAL_RANDOM;
	/** Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ€ÐµÐ°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð½Ð´Ð¾Ð¼Ð¸Ð½Ð°Ð¹Ð·ÐµÑ€ Ð´Ð»Ñ� Ð¾Ð¿Ñ€Ð¾ÐºÐ¸Ð´Ñ‹Ð²Ð°Ð½Ð¸Ñ� */
	public static boolean SERVER_OWERTURN_REAL_RANDOM;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð³ÐµÐ¾ Ð´Ð²Ð¸Ð¶ÐºÐ°
	 * -------------------------------------
	 */

	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð³ÐµÐ¾ ÐºÐ°Ñ€Ñ‚Ñ‹ Ð¿Ð¾ Ð¥ */
	public static int GEO_ENGINE_OFFSET_X;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð³ÐµÐ¾ ÐºÐ°Ñ€Ñ‚Ñ‹ Ð¿Ð¾ Y */
	public static int GEO_ENGINE_OFFSET_Y;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð³ÐµÐ¾ ÐºÐ²Ð°Ð´Ñ€Ð°Ñ‚Ð° */
	public static int GEO_ENGINE_QUARD_SIZE;
	/** Ð²Ñ‹Ñ�Ð¾Ñ‚Ð° Ð³ÐµÐ¾ ÐºÐ²Ð°Ð´Ñ€Ð°Ñ‚Ð° */
	public static int GEO_ENGINE_QUARD_HEIGHT;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð¸Ð³Ñ€Ð¾Ð²Ð¾Ð³Ð¾ Ð¼Ð¸Ñ€Ð°
	 * ----------------------------------
	 */

	/** Ð²Ñ€ÐµÐ¼Ñ� Ð¶Ð¸Ð·Ð½Ð¸ Ð²Ñ‹Ð¿Ð°Ð²ÑˆÐµÐ³Ð¾ Ð¸Ñ‚ÐµÐ¼Ð° */
	public static int WORLD_LIFE_TIME_DROP_ITEM;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð±Ð»Ð¾ÐºÐ¸Ñ€Ð¾Ð²ÐºÐ¸ Ð²Ñ‹Ð¿Ð°Ð²ÑˆÐµÐ³Ð¾ Ð¸Ñ‚ÐµÐ¼Ð° Ð½Ð° Ð¿Ð¾Ð´Ð½Ñ�Ñ‚Ð¸Ðµ Ñ‡ÑƒÐ¶Ð°ÐºÐ¾Ð¼ */
	public static int WORLD_BLOCK_TIME_DROP_ITEM;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð¾Ñ�Ñ‚ÑƒÐ¿Ð° Ð´Ð»Ñ� Ð²Ñ…Ð¾Ð´Ð° Ð² Ð¼Ð¸Ñ€ */
	public static int WORLD_MIN_ACCESS_LEVEL;
	/** Ñ‡ÐµÑ€ÐµÐ· Ñ�ÐºÐ¾Ð»ÑŒÐºÐ¾ ÑƒÑ�Ð¿ÐµÑˆÐ½Ñ‹Ñ… Ð°Ñ‚Ð°Ðº ÑƒÐ¼ÐµÐ½ÑŒÑˆÐ°Ñ‚ÑŒ ÐºÐ¾Ð»-Ð²Ð¾ Ñ�ÐµÑ€Ð´ÐµÑ‡ÐµÐº */
	public static int WORLD_PLAYER_THRESHOLD_ATTACKS;
	/** Ñ‡ÐµÑ€ÐµÐ· Ñ�ÐºÐ¾Ð»ÑŒÐºÐ¾ ÑƒÑ�Ð¿ÐµÑˆÐ½Ñ‹Ñ… Ð¾Ñ‚Ñ€Ð°Ð¶ÐµÐ½Ð¸Ð¹ Ð°Ñ‚Ð°Ðº ÑƒÐ¼ÐµÐ½ÑŒÑˆÐ°Ñ‚ÑŒ ÐºÐ¾Ð»-Ð²Ð¾ Ñ�ÐµÑ€Ð´ÐµÑ‡ÐµÐº */
	public static int WORLD_PLAYER_THRESHOLD_BLOOKS;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð½Ð°Ñ…Ð¾Ð¶Ð´ÐµÐ½Ð¸Ñ� Ð² Ð±Ð¾ÐµÐ²Ð¾Ð¹ Ñ�Ñ‚Ð¾Ð¹ÐºÐµ */
	public static int WORLD_PLAYER_TIME_BATTLE_STANCE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð°Ñ� Ñ€Ð°Ð·Ð½Ð¸Ñ†Ð° ÑƒÑ€Ð¾Ð²Ð½Ñ� Ð¸Ð³Ñ€Ð¾ÐºÐ°-Ð¼Ð¾Ð± Ð´Ð»Ñ� Ð²Ñ‹Ð¿Ð°Ð´ÐµÐ½Ð¸Ñ� Ð´Ñ€Ð¾Ð¿Ð° */
	public static int WORLD_MAX_DIFF_LEVEL_ON_DROP;
	/** ÑˆÐ¸Ñ€Ð¸Ð½Ð° Ñ€ÐµÐ³Ð¸Ð¾Ð½Ð° Ð² Ð¼Ð¸Ñ€Ðµ */
	public static int WORLD_WIDTH_REGION;
	/** Ð²Ñ‹Ñ�Ð¾Ñ‚Ð° Ñ€ÐµÐ³Ð¸Ð¾Ð½Ð° Ð² Ð¼Ð¸Ñ€Ðµ */
	public static int WORLD_HEIGHT_REGION;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¾Ð½Ð»Ð°Ð¹Ð½ */
	public static int WORLD_MAXIMUM_ONLINE;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð±Ð°Ð½ÐºÐ¾Ð² Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² */
	public static int WORLD_BANK_MAX_SIZE;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð±Ð°Ð½ÐºÐ¾Ð² Ð³Ð¸Ð»ÑŒÐ´Ð¸Ð¸ */
	public static int WORLD_GUILD_BANK_MAX_SIZE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾ Ð´Ð¾Ñ�Ñ‚ÑƒÐ¿Ð½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð¸Ð³Ñ€Ð¾ÐºÐ° */
	public static int WORLD_PLAYER_MAX_LEVEL;
	/** ÑˆÐ°Ð½Ñ� ÑƒÐ´Ð°Ð»ÐµÐ½Ð¸Ñ� ÐºÑ€Ð¸Ñ�Ñ‚Ð°Ð»Ð° Ð¿Ñ€Ð¸ Ñ�Ð¼ÐµÑ€Ñ‚Ð¸ */
	public static int WORLD_CHANCE_DELETE_CRYSTAL;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ñ�Ð±Ð¾Ñ€Ð° */
	public static int WORLD_MAX_COLLECT_LEVEL;
	/** ÐºÐ¾Ð»-Ð²Ð¾ ÐºÐ¾Ð½Ñ‚Ð¸Ð½ÐµÐ½Ñ‚Ð¾Ð² Ð² Ð¼Ð¸Ñ€Ðµ */
	public static int WORLD_CONTINENT_COUNT;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð°Ñ� Ð´Ð¸Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ñ� Ð´Ð»Ñ� Ñ€Ð°Ð±Ð¾Ñ‚Ñ‹ Ñ‚Ñ€ÐµÐ¹Ð´Ð° */
	public static int WORLD_TRADE_MAX_RANGE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð°Ñ� Ð´Ð¸Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ñ� Ð´Ð»Ñ� Ñ€Ð°Ð±Ð¾Ñ‚Ñ‹ Ð´ÑƒÑ�Ð»Ð¸ */
	public static int WORLD_DUEL_MAX_RANGE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð°Ñ� Ð´Ð¸Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ñ� Ð´Ð»Ñ� Ð¿Ñ€Ð¸Ð³Ð»Ð°ÑˆÐµÐ½Ð¸Ñ� Ð² Ð“Ð˜ */
	public static int WORLD_GUILD_INVITE_MAX_RANGE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾ Ð´Ð¾Ð¿ÑƒÑ�Ñ‚Ð¸Ð¼Ð°Ñ� Ñ€Ð°Ñ�Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð¸Ð·Ð°Ñ†Ð¸Ñ� Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	public static int WORLD_MAX_SKILL_DESYNC;
	/** ÑˆÐ°Ð½Ñ� Ð·Ð°Ñ‚Ð¾Ñ‡ÐºÐ¸ Ð¿Ñ€ÐµÐ´Ð¼ÐµÑ‚Ð° */
	public static int WORLD_ENCHANT_ITEM_CHANCE;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ñ†ÐµÐ»Ð¸ Ð´Ð»Ñ� Ð²Ð¾Ð·Ð¼Ð¾Ð¶Ð½Ð¾Ñ�Ñ‚Ð¸ Ñ�Ð»Ð¸Ñ‚ÑŒ Ð² Ð¿Ðº */
	public static int WORLD_MIN_TARGET_LEVEL_FOR_PK;

	/** Ð³Ð»Ð¾Ð±Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¼Ð¾Ð´Ð¸Ñ„Ð¸ÐºÐ°Ñ‚Ð¾Ñ€ Ð¾Ñ‚ÐºÐ°Ñ‚Ð° Ð¼Ð¸Ð»Ð¸ Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	public static float WORLD_SHORT_SKILL_REUSE_MOD;
	/** Ð³Ð»Ð¾Ð±Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¼Ð¾Ð´Ð¸Ñ„Ð¸ÐºÐ°Ñ‚Ð¾Ñ€ Ð¾Ñ‚ÐºÐ°Ñ‚Ð° Ð´Ð°Ð»ÑŒÐ½Ð¸Ñ… Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	public static float WORLD_RANGE_SKILL_REUSE_MOD;
	/** Ð³Ð»Ð¾Ð±Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¼Ð¾Ð´Ð¸Ñ„Ð¸ÐºÐ°Ñ‚Ð¾Ñ€ Ð¾Ñ‚ÐºÐ°Ñ‚Ð° Ð¾Ñ�Ñ‚Ð°Ð»ÑŒÐ½Ñ‹Ñ… Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	public static float WORLD_OTHER_SKILL_REUSE_MOD;

	/** Ñ�Ð¿Ð¸Ñ�Ð¾Ðº Ð´Ð¾Ð½Ð°Ñ‚ Ð¸Ñ‚ÐµÐ¼Ð¾Ð² */
	public static int[] WORLD_DONATE_ITEMS;

	/** Ð¼Ð¾Ð´Ð¸Ñ„Ð¸ÐºÐ°Ñ‚Ð¾Ñ€ Ñ†ÐµÐ½ Ð²Ð¼Ð°Ð³Ð°Ð·Ð¸Ð½Ðµ */
	public static float WORLD_SHOP_PRICE_MOD;

	/** Ð¸Ð·ÑƒÑ‡Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ�ÐºÐ¸Ð»Ñ‹ Ð°Ð²Ñ‚Ð¾Ð¼Ð°Ñ‚Ð¸Ñ‡ÐµÑ�ÐºÐ¸ */
	public static boolean WORLD_AUTO_LEARN_SKILLS;
	/** Ð´Ð¾Ñ�Ñ‚ÑƒÐ¿Ð½Ð¾ Ð»Ð¸ ÐŸÐš Ð½Ð° Ñ�ÐµÑ€Ð²ÐµÑ€Ðµ */
	public static boolean WORLD_PK_AVAILABLE;
	/** Ð¸Ð·ÑƒÑ‡Ð°Ñ‚ÑŒ Ñ‚Ð¾Ð»ÑŒÐºÐ¾ Ñ€ÐµÐ°Ð»Ð¸Ð·Ð¾Ð²Ð°Ð½Ð½Ñ‹Ðµ Ñ�ÐºÐ¸Ð»Ñ‹ */
	public static boolean WORLD_LEARN_ONLY_IMPLEMENTED_SKILLS;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð±Ð°Ð·Ñ‹ Ð´Ð°Ð½Ð½Ñ‹Ñ…
	 * ----------------------------------
	 */

	/** Ñ�ÐºÐ·ÐµÐ¼Ð¿Ð»Ñ�Ñ€ ÐºÐ¾Ð½Ñ„Ð¸Ð³Ð° Ð´Ð»Ñ� Ð‘Ð” */
	public static final BoneCPConfig DATA_BASE_CONFIG = new BoneCPConfig();

	/** ÐºÐ»Ð°Ñ�Ñ� Ð´Ñ€Ð°Ð¹Ð²ÐµÑ€Ð° Ð±Ð°Ð·Ñ‹ Ð´Ð°Ð½Ð½Ñ‹Ñ… */
	public static String DATA_BASE_DRIVER;
	/** Ð°Ð´Ñ€ÐµÑ�Ñ� Ð±Ð°Ð·Ñ‹ Ð´Ð°Ð½Ð½Ñ‹Ñ… */
	public static String DATA_BASE_URL;
	/** Ð»Ð¾Ð³Ð¸Ð½ Ð´Ð»Ñ� Ð´Ð¾Ñ�Ñ‚ÑƒÐ¿Ð° Ðº Ð±Ð°Ð·Ðµ Ð´Ð°Ð½Ð½Ñ‹Ñ… */
	public static String DATA_BASE_LOGIN;
	/** Ð¿Ð°Ñ€Ð¾Ð»ÑŒ Ð´Ð»Ñ� Ð´Ð¾Ñ�Ñ‚ÑƒÐ¿Ð° Ðº Ð±Ð°Ð·Ðµ Ð´Ð°Ð½Ð½Ñ‹Ñ… */
	public static String DATA_BASE_PASSWORD;

	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ ÐºÐ¾Ð½Ð½ÐµÐºÑ‚Ð¾Ð² Ðº Ð±Ð°Ð·Ðµ Ð² Ð¿ÑƒÐ»Ðµ */
	public static int DATA_BASE_MAX_CONNECTIONS;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ Ñ�Ð¾Ð·Ð´Ð°Ð²Ð°ÐµÐ¼Ñ‹Ñ… statements */
	public static int DATA_BASE_MAX_STATEMENTS;

	/** Ñ‡Ð¸Ñ�Ñ‚Ð¸Ñ‚ÑŒ Ð»Ð¸ Ð‘Ð” Ð¿Ñ€Ð¸ Ñ�Ñ‚Ð°Ñ€Ñ‚Ðµ Ñ�ÐµÑ€Ð²ÐµÑ€Ð° */
	public static boolean DATA_BASE_CLEANING_START;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð²
	 * ----------------------------------
	 */

	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¾Ñ�Ð½Ð¾Ð²Ð½Ñ‹Ñ… Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² */
	public static int THREAD_POOL_SIZE_GENERAL;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² Ð´Ð²Ð¸Ð¶ÐµÐ½Ð¸Ñ� */
	public static int THREAD_POOL_SIZE_MOVE;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² Ð�Ð˜ */
	;
	public static int THREAD_POOL_SIZE_AI;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² Ð¿Ñ€Ð¸Ð¼ÐµÐ½ÐµÐ½Ð¸Ñ� Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	;
	public static int THREAD_POOL_SIZE_SKILL_USE;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² ÐºÐ°Ñ�Ñ‚Ð° Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	;
	public static int THREAD_POOL_SIZE_SKILL_CAST;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² Ð¿ÐµÑ€ÐµÐ´Ð²ÐµÐ¶ÐµÐ½Ð¸Ñ� Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	;
	public static int THREAD_POOL_SIZE_SKILL_MOVE;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð¿ÑƒÐ»Ð° Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð², Ð¸Ñ�Ð¿Ð¾Ð»Ð½Ñ�ÑŽÑ‰Ð¸Ð¹ Ð°Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð½Ð¾ ÐºÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ðµ Ð¿Ð°ÐºÐµÑ‚Ñ‹ */
	public static int THREAD_POOL_PACKET_RUNNER;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð´Ð»Ñ� Ñ€Ð°Ð·Ñ€Ð°Ð±Ð¾Ñ‚ÐºÐ¸
	 * ----------------------------------
	 */

	/** ÑƒÑ�Ñ‚Ð°Ð½Ð¾Ð²ÐºÐ¸ Ð¿Ñ€Ð¸Ð½ÑƒÐ´Ð¸Ñ‚ÐµÐ»ÑŒÐ½Ð¾Ð¹ Ñ�ÐºÐ¾Ñ€Ð¾Ñ�Ñ‚Ð¸ Ð°Ñ‚Ð°ÐºÐ¸ */
	public static int DEVELOPER_FORCE_ATTACK_SPEED;

	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð´ÐµÐ±Ð°Ð³ Ð¸Ð½Ñ„Ñ‹ Ð¾ Ð¿ÐµÑ€ÐµÑ�Ñ‹Ð»ÐºÐµ ÐºÐ»Ð¸ÐµÐ½Ñ‚ Ð¿Ð°ÐºÐµÑ‚Ð¾Ð² */
	public static boolean DEVELOPER_DEBUG_CLIENT_PACKETS;
	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð´ÐµÐ±Ð°Ð³ Ð¸Ð½Ñ„Ñ‹ Ð¾ Ð¿ÐµÑ€ÐµÑ�Ñ‹Ð»ÐºÐµ Ñ�ÐµÑ€Ð²ÐµÑ€Ð½Ñ‹Ñ… Ð¿Ð°ÐºÐµÑ‚Ð¾Ð² */
	public static boolean DEVELOPER_DEBUG_SERVER_PACKETS;
	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð¾Ð±Ñ‰ÐµÐ¹ Ð´ÐµÐ±Ð°Ð³ Ð¸Ð½Ñ„Ñ‹ */
	public static boolean DEVELOPER_MAIN_DEBUG;
	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð´ÐµÐ±Ð°Ð³Ð° Ñ�Ð²Ñ�Ð·Ð°Ð½Ð½Ð¾Ð³Ð¾ Ñ� Ñ€Ð°Ñ�Ñ‡ÐµÑ‚Ð¾Ð¼ Ñ‚Ð°Ñ€Ð³ÐµÑ‚Ð¾Ð² Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	public static boolean DEVELOPER_DEBUG_TARGET_TYPE;
	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð´ÐµÐ±Ð°Ð³Ð° Ñ�Ð²Ñ�Ð·Ð°Ð½Ð½Ð¾Ð³Ð¾ Ñ� ÐºÐ°Ñ�Ñ‚Ð¾Ð¼ Ñ�ÐºÐ¸Ð»Ð° */
	public static boolean DEVELOPER_DEBUG_CASTING_SKILL;
	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð´ÐµÐ±Ð°Ð³Ð° Ñ�Ð²Ñ�Ð·Ð°Ð½Ð½Ð¾Ð³Ð¾ Ñ� Ð¿ÐµÑ€ÐµÐ¼ÐµÑ‰ÐµÐ½Ð¸ÐµÐ¼ Ð¸Ð³Ñ€Ð¾ÐºÐ° */
	public static boolean DEVELOPER_DEBUG_MOVING_PLAYER;
	/** Ð²Ñ‹Ð²Ð¾Ð´ Ð´ÐµÐ±Ð°Ð³Ð° Ñ�Ð²Ñ�Ð·Ð°Ð½Ð½Ð¾Ð³Ð¾ Ñ� Ð¿ÐµÑ€ÐµÐ¼ÐµÑ‰ÐµÐ½Ð¸ÐµÐ¼ Ð½Ð¿Ñ� */
	public static boolean DEVELOPER_DEBUG_MOVING_NPC;
	/** Ð°ÐºÑ‚Ð¸Ð²Ð¸Ñ€Ð¾Ð²Ð°Ñ‚ÑŒ Ð»Ð¸ Ð»Ð¾Ð³Ð¸Ñ€Ð¾Ð²Ð°Ð½Ð¸Ðµ Ð¿ÐµÑ€ÐµÐ¼ÐµÑ‰ÐµÐ½Ð¸Ñ� Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² */
	public static boolean DEVELOPER_GEO_LOGING;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð�Ð˜
	 * ----------------------------------
	 */

	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð´Ð¸ÑƒÑ� Ð´ÐµÐ¹Ñ�Ñ‚Ð²Ð¸Ñ� Ð¼Ð¾Ð±Ð° */
	public static int AI_MAX_ACTIVE_RANGE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€Ð°Ð´Ð¸ÑƒÑ� Ñ€ÐµÐ°Ð³Ð¸Ñ€Ð¾Ð²Ð°Ð½Ð¸Ñ� Ð¼Ð¾Ð±Ð° */
	public static int AI_MAX_REACTION_RANGE;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€ÐµÐ½Ð¶ Ñ�Ð»ÑƒÑ‡Ð°Ð¹Ð½Ð¾Ð³Ð¾ Ð±Ñ€Ð¾Ð¶Ð´ÐµÐ½Ð¸Ñ� Ð¾Ñ‚ Ñ‚Ð¾Ñ‡ÐºÐ¸ Ñ€ÐµÑ�Ð¿Ð°Ð²Ð½Ð° */
	public static int AI_MIN_RANDOM_WALK_RANGE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ñ€ÐµÐ½Ð¶ Ñ�Ð»ÑƒÑ‡Ð°Ð¹Ð½Ð¾Ð³Ð¾ Ð±Ñ€Ð¾Ð¶Ð´ÐµÐ½Ð¸Ñ� Ð¾Ñ‚ Ñ‚Ð¾Ñ‡ÐºÐ¸ Ñ�Ð¿Ð°Ð²Ð½Ð° */
	public static int AI_MAX_RANDOM_WALK_RANGE;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð¼ÐµÐ¶Ð´Ñƒ Ð±Ñ€Ð¾Ð¶Ð´ÐµÐ½Ð¸ÐµÐ¼ */
	public static int AI_MIN_RANDOM_WALK_DELAY;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð¼ÐµÐ¶Ð´Ñƒ Ð±Ñ€Ð¾Ð¶Ð´ÐµÐ½Ð¸ÐµÐ¼ */
	public static int AI_MAX_RANDOM_WALK_DELAY;
	/** Ð¿Ñ€Ð¾Ð¼ÐµÐ¶ÑƒÑ‚Ð¾Ðº Ð¼ÐµÐ¶Ð´Ñƒ Ð²Ñ‹Ð¿Ð¾Ð»Ð½ÐµÐ½Ð¸ÐµÐ¼ Ð�Ð˜ Ñ‚Ð°Ñ�ÐºÐ¾Ð² */
	public static int AI_TASK_DELAY;

	/** ÑˆÐ°Ð½Ñ�Ñ‹ Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ð½Ð¸ Ñ�ÐºÐ¸Ð»Ð¾Ð² */
	public static int AI_ATTACK_RATE;
	public static int AI_BUFF_RATE;
	public static int AI_DEBUFF_RATE;
	public static int AI_DEFENSE_RATE;
	public static int AI_JUMP_RATE;
	public static int AI_ULTIMATE_RATE;
	public static int AI_SIDE_RATE;
	public static int AI_SPRINT_RATE;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð°Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð½Ð¾Ð¹ Ñ�ÐµÑ‚Ð¸
	 * ----------------------------------
	 */
	/**
	 * /** ÐºÐ¾Ð»-Ð²Ð¾ Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² Ð² Ð°Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð½Ð¾Ð¹ Ñ�ÐµÑ‚Ð¸
	 */
	public static int NETWORK_GROUP_SIZE;
	/** Ð¿Ñ€Ð¸Ð¾Ñ€Ð¸Ñ‚ÐµÑ‚ Ð¿Ð¾Ñ‚Ð¾ÐºÐ¾Ð² Ð°Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð½Ð¾Ð¹ Ñ�ÐµÑ‚Ð¸ */
	public static int NETWORK_THREAD_PRIORITY;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð±ÑƒÑ„Ñ„ÐµÑ€Ð° ÐºÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ñ… Ð¿Ð°ÐºÐµÑ‚Ð¾Ð² */
	public static int NETWORK_READ_BUFFER_SIZE;
	/** Ñ€Ð°Ð·Ð¼ÐµÑ€ Ð±ÑƒÑ„ÐµÑ€Ð° Ñ�ÐµÑ€Ð²ÐµÑ€Ð½Ñ‹Ñ… Ð¿Ð°ÐºÐµÑ‚Ð¾Ð² */
	public static int NETWORK_WRITE_BUFFER_SIZE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ Ñ‡Ð¸Ñ�Ð»Ð¾ Ñ€Ð°Ð·Ñ€ÐµÐ·Ð°ÐµÐ¼Ñ‹Ñ… Ð¿Ð°ÐºÐµÑ‚Ð¾Ð² */
	public static int NETWORK_MAXIMUM_PACKET_CUT;

	/** Ð¾Ñ‚Ð¾Ð±Ñ€Ð°Ð¶Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ�ÐºÑ�ÐµÐ¿ÑˆÐµÐ½Ñ‹ Ñ‡Ð¸Ñ‚Ð°ÐµÐ¼Ð¾Ð¹ Ñ�ÐµÑ‚Ð¸ */
	public static boolean NETWORK_VISIBLE_READ_EXCEPTION;
	/** Ð¾Ñ‚Ð¾Ð±Ñ€Ð°Ð¶Ð°Ñ‚ÑŒ Ð»Ð¸ Ñ�ÐºÑ�ÐµÐ¿ÑˆÐµÐ½Ñ‹ Ð·Ð°Ð¿Ð¸Ñ�Ñ‹Ð²Ð°ÐµÐ¼Ð¾Ð¹ Ñ�ÐµÑ‚Ð¸ */
	public static boolean NETWORK_VISIBLE_WRITE_EXCEPTION;

	/**
	 * --------------------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð¸Ð²ÐµÐ½Ñ‚Ð¾Ð²
	 * -----------------------------------------
	 */

	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¸Ð½Ñ‚ÐµÑ€Ð²Ð°Ð» Ð¼ÐµÐ¶Ð´Ñƒ Ð°Ð²Ñ‚Ð¾ Ð¸Ð²ÐµÐ½Ñ‚Ð°Ð¼Ð¸ */
	public static int EVENT_MIN_TIMEOUT;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ Ð¸Ð½Ñ‚ÐµÑ€Ð²Ð°Ð» Ð¼ÐµÐ¶Ð´Ñƒ Ð°Ð²Ñ‚Ð¾ Ð¸Ð²ÐµÐ½Ñ‚Ð°Ð¼Ð¸ */
	public static int EVENT_MAX_TIMEOUT;

	/** Ð²Ñ€ÐµÐ¼Ñ� Ñ€ÐµÐ³Ð¸Ñ�Ñ‚Ñ€Ð°Ñ†Ð¸Ð¸ Ð½Ð° Ð¢Ð²Ð¢ */
	public static int EVENT_TVT_REGISTER_TIME;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð±Ð¾Ñ� Ð½Ð° Ð¢Ð²Ð¢ */
	public static int EVENT_TVT_BATTLE_TIME;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð² Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° Ð¢Ð²Ð¢ */
	public static int EVENT_TVT_MIN_PLAYERS;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° Ð¢Ð²Ð¢ */
	public static int EVENT_TVT_MAX_PLAYERS;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ð¢Ð²Ð¢ */
	public static int EVENT_TVT_MIN_LEVEL;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ð¢Ð²Ð¢ */
	public static int EVENT_TVT_MAX_LEVEL;

	/** Ð²Ñ€ÐµÐ¼Ñ� Ñ€ÐµÐ³Ð¸Ñ�Ñ‚Ñ€Ð°Ñ†Ð¸Ð¸ Ð½Ð° Ð›Ð¥ */
	public static int EVENT_LH_REGISTER_TIME;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð±Ð¾Ñ� Ð½Ð° Ð›Ð¥ */
	public static int EVENT_LH_BATTLE_TIME;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð² Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° Ð›Ð¥ */
	public static int EVENT_LH_MIN_PLAYERS;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° Ð›Ð¥ */
	public static int EVENT_LH_MAX_PLAYERS;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ð›Ð¥ */
	public static int EVENT_LH_MIN_LEVEL;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ð›Ð¥ */
	public static int EVENT_LH_MAX_LEVEL;

	/** Ð²Ñ€ÐµÐ¼Ñ� Ñ€ÐµÐ³Ð¸Ñ�Ñ‚Ñ€Ð°Ñ†Ð¸Ð¸ Ð½Ð° Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_REGISTER_TIME;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð±Ð¾Ñ� Ð½Ð° Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_BATTLE_TIME;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð² ÐºÐ¾Ð¼Ð°Ð½Ð´ Ð½Ð° Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_MIN_TEAMS;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ ÐºÐ¾Ð¼Ð°Ð½Ð´ Ð½Ð° Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_MAX_TEAMS;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð² Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð² ÐºÐ¾Ð¼Ð°Ð½Ð´Ðµ Ð½Ð° Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_MIN_TEAM_SIZE;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð² ÐºÐ¾Ð¼Ð°Ð½Ð´Ðµ Ð½Ð° Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_MAX_TEAM_SIZE;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_MIN_LEVEL;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ð¢ÐœÐ¢ */
	public static int EVENT_TMT_MAX_LEVEL;

	/** Ð²Ñ€ÐµÐ¼Ñ� Ñ€ÐµÐ³Ð¸Ñ�Ñ‚Ñ€Ð°Ñ†Ð¸Ð¸ Ð½Ð° Ñ‚Ð²Ðœ */
	public static int EVENT_EB_REGISTER_TIME;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð±Ð¾Ñ� Ð½Ð° Ñ‚Ð²Ðœ */
	public static int EVENT_EB_BATTLE_TIME;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð² Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° Ñ‚Ð²Ðœ */
	public static int EVENT_EB_MIN_PLAYERS;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° Ð¢Ð²Ñ‚Ð²ÐœÐ¢ */
	public static int EVENT_EB_MAX_PLAYERS;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ñ‚Ð²Ðœ */
	public static int EVENT_EB_MIN_LEVEL;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� Ñ‚Ð²Ðœ */
	public static int EVENT_EB_MAX_LEVEL;

	/** Ð²Ñ€ÐµÐ¼Ñ� Ñ€ÐµÐ³Ð¸Ñ�Ñ‚Ñ€Ð°Ñ†Ð¸Ð¸ Ð½Ð° TDM */
	public static int EVENT_TDM_REGISTER_TIME;
	/** Ð²Ñ€ÐµÐ¼Ñ� Ð±Ð¾Ñ� Ð½Ð° TDM */
	public static int EVENT_TDM_BATTLE_TIME;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð² Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° TDM */
	public static int EVENT_TDM_MIN_PLAYERS;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾Ðµ ÐºÐ¾Ð»-Ð²Ð¾ Ð¸Ð³Ñ€Ð¾ÐºÐ¾Ð² Ð½Ð° TDM */
	public static int EVENT_TDM_MAX_PLAYERS;
	/** Ð¼Ð¸Ð½Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� TDM */
	public static int EVENT_TDM_MIN_LEVEL;
	/** Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ñ‹Ð¹ ÑƒÑ€Ð¾Ð²ÐµÐ½ÑŒ Ð´Ð»Ñ� TDM */
	public static int EVENT_TDM_MAX_LEVEL;

	/** Ñ�ÐºÐ¾Ð»ÑŒÐºÐ¾ Ð´ÐµÐ½ÐµÐ³ Ð·Ð° 1 Ð¾Ñ‡ÐºÐ¾ Ñ�Ð»Ð°Ð²Ñ‹ */
	public static int EVENT_HERO_POINT_TO_GOLD;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð´Ð¸Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¾Ð½Ð½Ð¾Ð³Ð¾ ÑƒÐ¿Ñ€Ð°Ð²Ð»ÐµÐ½Ð¸Ñ�
	 * ----------------------------------
	 */

	/** Ð»Ð¾Ð³Ð¸Ð½ Ð´Ð»Ñ� Ð¿Ð¾Ð´ÐºÐ»ÑŽÑ‡ÐµÐ½Ð¸Ñ� ÑƒÐ¾Ð½Ñ‚Ñ€Ð¾Ð»Ð° */
	public static String DIST_CONTROL_LOGIN;
	/** Ð¿Ð°Ñ€Ð¾Ð»ÑŒ Ð´Ð»Ñ� Ð¿Ð¾Ð´ÐºÐ»ÑŽÑ‡ÐµÐ½Ð¸Ñ� ÑƒÐ¾Ð½Ñ‚Ñ€Ð¾Ð»Ð° */
	public static String DIST_CONTROL_PASSWORD;

	/** Ð¿Ð¾Ñ€Ñ‚ Ñ�ÐµÑ€Ð²ÐµÑ€Ð° Ð´Ð¸Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¾Ð½Ð½Ð¾Ð³Ð¾ ÑƒÐ¿Ñ€Ð°Ð²Ð»ÐµÐ½Ð¸Ñ� */
	public static int DIST_CONTROL_PORT;
	/** Ð¸Ð½Ñ‚ÐµÑ€Ð²Ð°Ð» Ð² Ñ†Ð¸ÐºÐ»Ðµ Ð¿Ñ€Ð¾Ð²ÐµÑ€ÐºÐµ Ñ�Ð¾Ñ�Ñ‚Ð¾Ñ�Ð½Ð¸Ñ� ÐºÐ»Ð¸ÐµÐ½Ñ‚Ð° */
	public static int DIST_CONTROL_CLIENT_INTERVAL;

	/** Ð²ÐºÐ»ÑŽÑ‡ÐµÐ½Ð¾ Ð»Ð¸ Ð´Ð¸Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¾Ð½Ð½Ð¾Ðµ ÑƒÐ¿Ñ€Ð°Ð²Ð»ÐµÐ½Ð¸Ðµ */
	public static boolean DIST_CONTROL_ENABLED;

	/**
	 * ---------------------------- Ð�Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð¸Ð²ÐµÐ½Ñ‚Ð¾Ð²
	 * ----------------------------------
	 */

	public static String EVENT_TEAM_VS_TEAM_NAME;

	public static int EVENT_TEAM_VS_TEAM_MIN_COUNT_PLAYERS;
	public static int EVENT_TEAM_VS_TEAM_MAX_COUNT_PLAYERS;

	/**
	 * ---------------------------- ÐžÑ�Ñ‚Ð°Ð»ÑŒÐ½Ð¾Ðµ ----------------------------------
	 */

	public static String SERVER_DIR;

	/** ÐºÐ¾Ð½Ñ„Ð¸Ð³ÑƒÑ€Ð°Ñ†Ð¸Ñ� Ð´Ð»Ñ� Ð³ÐµÐ¾ Ð´Ð²Ð¸Ð¶ÐºÐ° */
	public static GeoConfig GEO_CONFIG = new GeoConfig() {

		@Override
		public int getOffsetX() {
			return GEO_ENGINE_OFFSET_X;
		}

		@Override
		public int getOffsetY() {
			return GEO_ENGINE_OFFSET_Y;
		}

		@Override
		public int getQuardHeight() {
			return GEO_ENGINE_QUARD_HEIGHT;
		}

		@Override
		public int getQuardSize() {
			return GEO_ENGINE_QUARD_SIZE;
		}

		@Override
		public int getSplit() {
			return 0;
		}
	};

	private static Pattern namePattern;

	/**
	 * ÐŸÑ€Ð¾Ð²ÐµÑ€ÐºÐ° ÐºÐ¾Ñ€Ñ€ÐµÐºÑ‚Ð½Ð¾Ñ�Ñ‚Ð¸ Ð¸Ð¼ÐµÐ½Ð¸Ñ� Ñ‡ÐµÐ³Ð¾-Ð»Ð¸Ð±Ð¾.
	 * 
	 * @param name Ð¿Ñ€Ð¾Ð²ÐµÑ€Ñ�ÐµÐ¼Ð¾Ðµ Ð¸Ð¼Ñ�.
	 * @return Ð¿Ñ€Ð¾Ñ…Ð¾Ð´Ð¸Ñ‚ Ð»Ð¸ Ð¿Ñ€Ð¾Ð²ÐµÑ€ÐºÑƒ Ð´Ð»Ñ� Ñ�ÐµÑ€Ð²ÐµÑ€Ð°.
	 */
	public static final boolean checkName(String name) {
		Matcher metcher = namePattern.matcher(name);

		return metcher.matches();
	}

	/**
	 * Ð¸Ð½Ð¸Ñ†Ð¸Ð°Ð»Ð¸Ð·Ð°Ñ†Ð¸Ñ� ÐºÐ¾Ð½Ñ„Ð¸Ð³Ð°
	 */
	public static void init() {
		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ñ€Ð°Ñ�Ð¿Ð¾Ð»Ð¾Ð¶ÐµÐ½Ð¸Ðµ Ñ�Ð±Ð¾Ñ€ÐºÐ¸ Ñ�ÐµÑ€Ð²ÐµÑ€Ð°
		SERVER_DIR = Util.getRootPath();

		SERVER_DIR = ".";

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð²ÐµÑ€Ñ�Ð¸ÑŽ Ñ�Ð´Ñ€Ð°
		SERVER_VERSION = "rev. " + (new File(SERVER_DIR + "/libs/stera.jar").lastModified() / 1000 / 60 % 1000000 - 600000);

		// Ñ�Ð¾Ð·Ð´Ð°ÐµÐ¼ Ñ‚Ð°Ð±Ð¸Ñ†Ñƒ Ñ�Ñ‚Ð°Ñ‚Ð¾Ð²
		VarTable vars = VarTable.newInstance();

		Loggers.info("Config", "dir : " + SERVER_DIR + ", " + SERVER_VERSION);

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð²Ñ�Ðµ Ñ„Ð°Ð¹Ð»Ñ‹ ÐºÐ¾Ð½Ñ„Ð¸Ð³Ð°
		File[] files = Files.getFiles(new File(SERVER_DIR + "/config"));

		// Ð¿Ð°Ñ€Ñ�Ð¸Ð¼ Ð²ÐµÑ�ÑŒ ÐºÐ¾Ð½Ñ„Ð¸Ð³
		parseFiles(files, vars);

		ACCOUNT_MIN_ACCESS_LEVEL = vars.getInteger("ACCOUNT_MIN_ACCESS_LEVEL");

		ACCOUNT_PREMIUM_EXP_RATE = vars.getFloat("ACCOUNT_PREMIUM_EXP_RATE");
		ACCOUNT_PREMIUM_MONEY_RATE = vars.getFloat("ACCOUNT_PREMIUM_MONEY_RATE");
		ACCOUNT_PREMIUM_DROP_RATE = vars.getFloat("ACCOUNT_PREMIUM_DROP_RATE");
		ACCOUNT_PREMIUM_QUEST_RATE = vars.getFloat("ACCOUNT_PREMIUM_QUEST_RATE");

		ACCOUNT_AUTO_CREATE = vars.getBoolean("ACCOUNT_AUTO_CREATE");
		ACCOUNT_ONLY_PAID = vars.getBoolean("ACCOUNT_ONLY_PAID");
		ACCOUNT_PREMIUM_EXP = vars.getBoolean("ACCOUNT_PREMIUM_EXP");
		ACCOUNT_PREMIUM_MONEY = vars.getBoolean("ACCOUNT_PREMIUM_MONEY");
		ACCOUNT_PREMIUM_DROP = vars.getBoolean("ACCOUNT_PREMIUM_DROP");
		ACCOUNT_PREMIUM_QUEST = vars.getBoolean("ACCOUNT_PREMIUM_QUEST");

		SERVER_NAME_TEMPLATE = vars.getString("SERVER_NAME_TEMPLATE");
		SERVER_ONLINE_FILE = vars.getString("SERVER_ONLINE_FILE", Strings.EMPTY);

		SERVER_PLAYER_SUB_ID = vars.getInteger("SERVER_PLAYER_SUB_ID");
		SERVER_NPC_SUB_ID = vars.getInteger("SERVER_NPC_SUB_ID");
		SERVER_ITEM_SUB_ID = vars.getInteger("SERVER_ITEM_SUB_ID");
		SERVER_SHOT_SUB_ID = vars.getInteger("SERVER_SHOT_SUB_ID");
		SERVER_OBJECT_SUB_ID = vars.getInteger("SERVER_OBJECT_SUB_ID");
		SERVER_TRAP_SUB_ID = vars.getInteger("SERVER_TRAP_SUB_ID");
		SERVER_RESOURSE_SUB_ID = vars.getInteger("SERVER_RESOURSE_SUB_ID");
		SERVER_PORT = vars.getInteger("SERVER_PORT");

		GEO_ENGINE_OFFSET_X = vars.getInteger("GEO_ENGINE_OFFSET_X");
		GEO_ENGINE_OFFSET_Y = vars.getInteger("GEO_ENGINE_OFFSET_Y");
		GEO_ENGINE_QUARD_SIZE = vars.getInteger("GEO_ENGINE_QUARD_SIZE");
		GEO_ENGINE_QUARD_HEIGHT = vars.getInteger("GEO_ENGINE_QUARD_HEIGHT");

		SERVER_RATE_EXP = vars.getFloat("SERVER_RATE_EXP");
		SERVER_PARTY_RATE_EXP = vars.getFloat("SERVER_PARTY_RATE_EXP");
		SERVER_RATE_MONEY = vars.getFloat("SERVER_RATE_MONEY");
		SERVER_RATE_DROP_ITEM = vars.getFloat("SERVER_RATE_DROP_ITEM");
		SERVER_RATE_QUEST_REWARD = vars.getFloat("SERVER_RATE_QUEST_REWARD");
		SERVER_ONLINE_FAKE = vars.getFloat("SERVER_ONLINE_FAKE");

		SERVER_USE_SNIFFER_OPCODE = vars.getBoolean("SERVER_USE_SNIFFER_OPCODE");
		SERVER_DROP_REAL_RANDOM = vars.getBoolean("SERVER_DROP_REAL_RANDOM");
		SERVER_CRIT_REAL_RANDOM = vars.getBoolean("SERVER_CRIT_REAL_RANDOM");
		SERVER_EFFECT_REAL_RANDOM = vars.getBoolean("SERVER_EFFECT_REAL_RANDOM");
		SERVER_FUNC_REAL_RANDOM = vars.getBoolean("SERVER_FUNC_REAL_RANDOM");
		SERVER_DAMAGE_REAL_RANDOM = vars.getBoolean("SERVER_DAMAGE_REAL_RANDOM");
		SERVER_OWERTURN_REAL_RANDOM = vars.getBoolean("SERVER_OWERTURN_REAL_RANDOM");

		WORLD_LIFE_TIME_DROP_ITEM = vars.getInteger("WORLD_LIFE_TIME_DROP_ITEM");
		WORLD_BLOCK_TIME_DROP_ITEM = vars.getInteger("WORLD_BLOCK_TIME_DROP_ITEM");
		WORLD_MIN_ACCESS_LEVEL = vars.getInteger("WORLD_MIN_ACCESS_LEVEL");
		WORLD_PLAYER_THRESHOLD_ATTACKS = vars.getInteger("WORLD_PLAYER_THRESHOLD_ATTACKS");
		WORLD_PLAYER_THRESHOLD_BLOOKS = vars.getInteger("WORLD_PLAYER_THRESHOLD_BLOOKS");
		WORLD_PLAYER_TIME_BATTLE_STANCE = vars.getInteger("WORLD_PLAYER_TIME_BATTLE_STANCE") * 1000;
		WORLD_MAX_DIFF_LEVEL_ON_DROP = vars.getInteger("WORLD_MAX_DIFF_LEVEL_ON_DROP");
		WORLD_WIDTH_REGION = vars.getInteger("WORLD_WIDTH_REGION");
		WORLD_HEIGHT_REGION = vars.getInteger("WORLD_HEIGHT_REGION");
		WORLD_MAXIMUM_ONLINE = vars.getInteger("WORLD_MAXIMUM_ONLINE");
		WORLD_BANK_MAX_SIZE = vars.getInteger("WORLD_BANK_MAX_SIZE");
		WORLD_GUILD_BANK_MAX_SIZE = vars.getInteger("WORLD_GUILD_BANK_MAX_SIZE");
		WORLD_MAX_COLLECT_LEVEL = vars.getInteger("WORLD_MAX_COLLECT_LEVEL");
		WORLD_CONTINENT_COUNT = vars.getInteger("WORLD_CONTINENT_COUNT");
		WORLD_TRADE_MAX_RANGE = vars.getInteger("WORLD_TRADE_MAX_RANGE");
		WORLD_DUEL_MAX_RANGE = vars.getInteger("WORLD_DUEL_MAX_RANGE");
		WORLD_GUILD_INVITE_MAX_RANGE = vars.getInteger("WORLD_GUILD_INVITE_MAX_RANGE");
		WORLD_MAX_SKILL_DESYNC = vars.getInteger("WORLD_MAX_SKILL_DESYNC") * vars.getInteger("WORLD_MAX_SKILL_DESYNC");
		WORLD_PLAYER_MAX_LEVEL = vars.getInteger("WORLD_PLAYER_MAX_LEVEL");
		WORLD_CHANCE_DELETE_CRYSTAL = vars.getInteger("WORLD_CHANCE_DELETE_CRYSTAL", 13);
		WORLD_MIN_TARGET_LEVEL_FOR_PK = vars.getInteger("WORLD_MIN_TARGET_LEVEL_FOR_PK");

		WORLD_SHORT_SKILL_REUSE_MOD = vars.getFloat("WORLD_SHORT_SKILL_REUSE_MOD");
		WORLD_RANGE_SKILL_REUSE_MOD = vars.getFloat("WORLD_RANGE_SKILL_REUSE_MOD");
		WORLD_OTHER_SKILL_REUSE_MOD = vars.getFloat("WORLD_OTHER_SKILL_REUSE_MOD");

		WORLD_DONATE_ITEMS = vars.getIntegerArray("WORLD_DONATE_ITEMS", ",", Arrays.toIntegerArray());

		WORLD_SHOP_PRICE_MOD = vars.getFloat("WORLD_SHOP_PRICE_MOD");

		WORLD_AUTO_LEARN_SKILLS = vars.getBoolean("WORLD_AUTO_LEARN_SKILLS");
		WORLD_PK_AVAILABLE = vars.getBoolean("WORLD_PK_AVAILABLE");
		WORLD_LEARN_ONLY_IMPLEMENTED_SKILLS = vars.getBoolean("WORLD_LEARN_ONLY_IMPLEMENTED_SKILLS");

		DATA_BASE_DRIVER = vars.getString("DATA_BASE_DRIVER");
		DATA_BASE_URL = vars.getString("DATA_BASE_URL");
		DATA_BASE_LOGIN = vars.getString("DATA_BASE_LOGIN");
		DATA_BASE_PASSWORD = vars.getString("DATA_BASE_PASSWORD");

		DATA_BASE_MAX_CONNECTIONS = vars.getInteger("DATA_BASE_MAX_CONNECTIONS");
		DATA_BASE_MAX_STATEMENTS = vars.getInteger("DATA_BASE_MAX_STATEMENTS");
		DATA_BASE_CLEANING_START = vars.getBoolean("DATA_BASE_CLEANING_START");

		THREAD_POOL_SIZE_GENERAL = vars.getInteger("THREAD_POOL_SIZE_GENERAL");
		THREAD_POOL_SIZE_MOVE = vars.getInteger("THREAD_POOL_SIZE_MOVE");
		THREAD_POOL_SIZE_AI = vars.getInteger("THREAD_POOL_SIZE_AI");
		THREAD_POOL_PACKET_RUNNER = vars.getInteger("THREAD_POOL_PACKET_RUNNER");
		THREAD_POOL_SIZE_SKILL_USE = vars.getInteger("THREAD_POOL_SIZE_SKILL_USE");
		THREAD_POOL_SIZE_SKILL_CAST = vars.getInteger("THREAD_POOL_SIZE_SKILL_CAST");
		THREAD_POOL_SIZE_SKILL_MOVE = vars.getInteger("THREAD_POOL_SIZE_SKILL_MOVE");

		DEVELOPER_FORCE_ATTACK_SPEED = vars.getInteger("DEVELOPER_FORCE_ATTACK_SPEED");
		DEVELOPER_DEBUG_CLIENT_PACKETS = vars.getBoolean("DEVELOPER_DEBUG_CLIENT_PACKETS");
		DEVELOPER_DEBUG_SERVER_PACKETS = vars.getBoolean("DEVELOPER_DEBUG_SERVER_PACKETS");
		DEVELOPER_MAIN_DEBUG = vars.getBoolean("DEVELOPER_MAIN_DEBUG");
		DEVELOPER_DEBUG_TARGET_TYPE = vars.getBoolean("DEVELOPER_DEBUG_TARGET_TYPE");
		DEVELOPER_DEBUG_CASTING_SKILL = vars.getBoolean("DEVELOPER_DEBUG_CASTING_SKILL");
		DEVELOPER_DEBUG_MOVING_PLAYER = vars.getBoolean("DEVELOPER_DEBUG_MOVING_PLAYER");
		DEVELOPER_DEBUG_MOVING_NPC = vars.getBoolean("DEVELOPER_DEBUG_MOVING_NPC");
		DEVELOPER_GEO_LOGING = vars.getBoolean("DEVELOPER_GEO_LOGING");

		EVENT_MIN_TIMEOUT = vars.getInteger("EVENT_MIN_TIMEOUT");
		EVENT_MAX_TIMEOUT = vars.getInteger("EVENT_MAX_TIMEOUT");
		EVENT_TVT_REGISTER_TIME = vars.getInteger("EVENT_TVT_REGISTER_TIME");
		EVENT_TVT_BATTLE_TIME = vars.getInteger("EVENT_TVT_BATTLE_TIME");
		EVENT_TVT_MIN_PLAYERS = vars.getInteger("EVENT_TVT_MIN_PLAYERS");
		EVENT_TVT_MAX_PLAYERS = vars.getInteger("EVENT_TVT_MAX_PLAYERS");
		EVENT_TVT_MIN_LEVEL = vars.getInteger("EVENT_TVT_MIN_LEVEL");
		EVENT_TVT_MAX_LEVEL = vars.getInteger("EVENT_TVT_MAX_LEVEL");
		EVENT_LH_REGISTER_TIME = vars.getInteger("EVENT_LH_REGISTER_TIME");
		EVENT_LH_BATTLE_TIME = vars.getInteger("EVENT_LH_BATTLE_TIME");
		EVENT_LH_MIN_PLAYERS = vars.getInteger("EVENT_LH_MIN_PLAYERS");
		EVENT_LH_MAX_PLAYERS = vars.getInteger("EVENT_LH_MAX_PLAYERS");
		EVENT_LH_MIN_LEVEL = vars.getInteger("EVENT_LH_MIN_LEVEL");
		EVENT_LH_MAX_LEVEL = vars.getInteger("EVENT_LH_MAX_LEVEL");
		EVENT_TMT_REGISTER_TIME = vars.getInteger("EVENT_TMT_REGISTER_TIME");
		EVENT_TMT_BATTLE_TIME = vars.getInteger("EVENT_TMT_BATTLE_TIME");
		EVENT_TMT_MIN_TEAMS = vars.getInteger("EVENT_TMT_MIN_TEAMS");
		EVENT_TMT_MAX_TEAMS = vars.getInteger("EVENT_TMT_MAX_TEAMS");
		EVENT_TMT_MIN_TEAM_SIZE = vars.getInteger("EVENT_TMT_MIN_TEAM_SIZE");
		EVENT_TMT_MAX_TEAM_SIZE = vars.getInteger("EVENT_TMT_MAX_TEAM_SIZE");
		EVENT_TMT_MIN_LEVEL = vars.getInteger("EVENT_TMT_MIN_LEVEL");
		EVENT_TMT_MAX_LEVEL = vars.getInteger("EVENT_TMT_MAX_LEVEL");
		EVENT_EB_REGISTER_TIME = vars.getInteger("EVENT_EB_REGISTER_TIME");
		EVENT_EB_BATTLE_TIME = vars.getInteger("EVENT_EB_BATTLE_TIME");
		EVENT_EB_MIN_PLAYERS = vars.getInteger("EVENT_EB_MIN_PLAYERS");
		EVENT_EB_MAX_PLAYERS = vars.getInteger("EVENT_EB_MAX_PLAYERS");
		EVENT_EB_MIN_LEVEL = vars.getInteger("EVENT_EB_MIN_LEVEL");
		EVENT_EB_MAX_LEVEL = vars.getInteger("EVENT_EB_MAX_LEVEL");
		EVENT_TDM_REGISTER_TIME = vars.getInteger("EVENT_TDM_REGISTER_TIME");
		EVENT_TDM_BATTLE_TIME = vars.getInteger("EVENT_TDM_BATTLE_TIME");
		EVENT_TDM_MIN_PLAYERS = vars.getInteger("EVENT_TDM_MIN_PLAYERS");
		EVENT_TDM_MAX_PLAYERS = vars.getInteger("EVENT_TDM_MAX_PLAYERS");
		EVENT_TDM_MIN_LEVEL = vars.getInteger("EVENT_TDM_MIN_LEVEL");
		EVENT_TDM_MAX_LEVEL = vars.getInteger("EVENT_TDM_MAX_LEVEL");
		EVENT_HERO_POINT_TO_GOLD = vars.getInteger("EVENT_HERO_POINT_TO_GOLD");

		AI_MAX_ACTIVE_RANGE = vars.getInteger("AI_MAX_ACTIVE_RANGE");
		AI_MAX_REACTION_RANGE = vars.getInteger("AI_MAX_REACTION_RANGE");
		AI_MIN_RANDOM_WALK_RANGE = vars.getInteger("AI_MIN_RANDOM_WALK_RANGE");
		AI_MAX_RANDOM_WALK_RANGE = vars.getInteger("AI_MAX_RANDOM_WALK_RANGE");
		AI_MIN_RANDOM_WALK_DELAY = vars.getInteger("AI_MIN_RANDOM_WALK_DELAY");
		AI_MAX_RANDOM_WALK_DELAY = vars.getInteger("AI_MAX_RANDOM_WALK_DELAY");
		AI_TASK_DELAY = vars.getInteger("AI_TASK_DELAY");

		AI_ATTACK_RATE = vars.getInteger("AI_ATTACK_RATE");
		AI_BUFF_RATE = vars.getInteger("AI_BUFF_RATE");
		AI_DEBUFF_RATE = vars.getInteger("AI_DEBUFF_RATE");
		AI_DEFENSE_RATE = vars.getInteger("AI_DEFENSE_RATE");
		AI_JUMP_RATE = vars.getInteger("AI_JUMP_RATE");
		AI_ULTIMATE_RATE = vars.getInteger("AI_ULTIMATE_RATE");
		AI_SIDE_RATE = vars.getInteger("AI_SIDE_RATE");
		AI_SPRINT_RATE = vars.getInteger("AI_SPRINT_RATE", 50);

		NETWORK_GROUP_SIZE = vars.getInteger("NETWORK_GROUP_SIZE");
		NETWORK_READ_BUFFER_SIZE = vars.getInteger("NETWORK_READ_BUFFER_SIZE");
		NETWORK_THREAD_PRIORITY = vars.getInteger("NETWORK_THREAD_PRIORITY");
		NETWORK_WRITE_BUFFER_SIZE = vars.getInteger("NETWORK_WRITE_BUFFER_SIZE");
		NETWORK_MAXIMUM_PACKET_CUT = vars.getInteger("NETWORK_MAXIMUM_PACKET_CUT");

		DIST_CONTROL_LOGIN = vars.getString("DIST_CONTROL_LOGIN");
		DIST_CONTROL_PASSWORD = vars.getString("DIST_CONTROL_PASSWORD");

		DIST_CONTROL_PORT = vars.getInteger("DIST_CONTROL_PORT");
		DIST_CONTROL_CLIENT_INTERVAL = vars.getInteger("DIST_CONTROL_CLIENT_INTERVAL");

		DIST_CONTROL_ENABLED = vars.getBoolean("DIST_CONTROL_ENABLED");

		DATA_BASE_CONFIG.setJdbcUrl(DATA_BASE_URL);
		DATA_BASE_CONFIG.setUsername(DATA_BASE_LOGIN);
		DATA_BASE_CONFIG.setPassword(DATA_BASE_PASSWORD);
		DATA_BASE_CONFIG.setAcquireRetryAttempts(0);
		DATA_BASE_CONFIG.setAcquireIncrement(5);
		DATA_BASE_CONFIG.setReleaseHelperThreads(0);
		DATA_BASE_CONFIG.setMinConnectionsPerPartition(2);
		DATA_BASE_CONFIG.setMaxConnectionsPerPartition(DATA_BASE_MAX_CONNECTIONS);
		DATA_BASE_CONFIG.setStatementsCacheSize(DATA_BASE_MAX_STATEMENTS);

		// Ð½Ð°Ñ�Ñ‚Ñ€Ð¾Ð¹ÐºÐ¸ Ð´Ð»Ñ� Ð¼ÑƒÑ�ÐºÑƒÐ» Ð´Ñ€Ð°Ð¹Ð²ÐµÑ€Ð°
		Properties properties = new Properties();

		// Ñ�Ñ‚Ð°Ð²Ð¸Ð¼ Ð¿Ñ€Ð¸Ð½ÑƒÐ´Ð¸Ñ‚ÐµÐ»ÑŒÐ½Ð¾Ðµ Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ð½Ð¸Ðµ UTF-8
		properties.setProperty("useUnicode", "true");
		properties.setProperty("characterEncoding", "UTF-8");

		// Ð´Ð¾Ð±Ð°Ð²Ð»Ñ�ÐµÐ¼ Ð² ÐºÐ¾Ð½Ñ„Ð¸Ð³ Ð¼ÑƒÑ�ÐºÑƒÐ» Ð´Ñ€Ð°Ð¹Ð²ÐµÑ€Ð°
		DATA_BASE_CONFIG.setDriverProperties(properties);

		namePattern = Pattern.compile(SERVER_NAME_TEMPLATE);

		Loggers.info("Config", "initialized.");
	}

	/**
	 * Ð§Ñ‚ÐµÐ½Ð¸Ðµ Ð¿Ð°Ñ€Ð°Ð¼ÐµÑ‚Ñ€Ð¾Ð² Ñ� Ñ„Ð°Ð¹Ð»Ð¾Ð²
	 * 
	 * @param files
	 */
	private static void parseFiles(File[] files, VarTable vars) {
		// Ð¿Ñ€Ð¾Ð±ÐµÐ³Ð°ÐµÐ¼Ñ�Ñ� Ð¿Ð¾ Ð²Ñ�ÐµÐ¼ Ñ„Ð°Ð¹Ð»Ð°Ð¼ Ð² Ð¿Ð°Ð¿ÐºÐµ ÐºÐ¾Ð½Ñ„Ð¸Ð³Ð°
		for(File file : files) {
			// ÐµÑ�Ð»Ð¸ Ñ„Ð°Ð¸Ð» Ñ�ÐºÑ€Ñ‹Ñ‚Ñ‹Ð¹, Ð¿Ñ€Ð¾Ð¿ÑƒÑ�ÐºÐ°ÐµÐ¼
			if(file.isHidden())
				continue;

			// ÐµÑ�Ð»Ð¸ Ð¿Ð°Ð¿ÐºÐ° Ð´ÐµÑ„Ð¾Ð»Ñ‚, Ð¿Ñ€Ð¾Ð¿ÑƒÑ�ÐºÐ°ÐµÐ¼
			if(file.isDirectory() && !file.getName().contains("defaults")) {
				parseFiles(file.listFiles(), vars);
				continue;
			}

			// ÐµÑ�Ð»Ð¸ Ñ„Ð°Ð¸Ð» Ñ…Ð¼Ð», Ð¿Ð°Ñ€Ñ�Ð¸Ð¼
			if(file.getName().endsWith(".xml"))
				vars.set(new DocumentConfig(file).parse());
		}
	}

	/**
	 * ÐŸÐµÑ€ÐµÐ·Ð°Ð³Ñ€ÑƒÐ·ÐºÐ° ÐºÐ¾Ð½Ñ„Ð¸Ð³Ð°.
	 */
	public static void reload() {
		// Ñ�Ð¾Ð·Ð´Ð°ÐµÐ¼ Ð½Ð¾Ð²ÑƒÑŽ Ñ‚Ð°Ð±Ð¸Ñ†Ñƒ Ñ�Ñ‚Ð°Ñ‚Ð¾Ð²
		VarTable vars = VarTable.newInstance();

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð²Ñ�Ðµ Ñ„Ð°Ð¹Ð»Ñ‹ ÐºÐ¾Ð½Ñ„Ð¸Ð³Ð°
		File[] files = Files.getFiles(new File(SERVER_DIR + "/config"));

		// Ð¿Ð°Ñ€Ñ�Ð¸Ð¼ Ð²ÐµÑ�ÑŒ ÐºÐ¾Ð½Ñ„Ð¸Ð³
		parseFiles(files, vars);

		ACCOUNT_MIN_ACCESS_LEVEL = vars.getInteger("ACCOUNT_MIN_ACCESS_LEVEL");

		ACCOUNT_PREMIUM_EXP_RATE = vars.getFloat("ACCOUNT_PREMIUM_EXP_RATE");
		ACCOUNT_PREMIUM_MONEY_RATE = vars.getFloat("ACCOUNT_PREMIUM_MONEY_RATE");
		ACCOUNT_PREMIUM_DROP_RATE = vars.getFloat("ACCOUNT_PREMIUM_DROP_RATE");
		ACCOUNT_PREMIUM_QUEST_RATE = vars.getFloat("ACCOUNT_PREMIUM_QUEST_RATE");

		ACCOUNT_AUTO_CREATE = vars.getBoolean("ACCOUNT_AUTO_CREATE");
		ACCOUNT_ONLY_PAID = vars.getBoolean("ACCOUNT_ONLY_PAID");
		ACCOUNT_PREMIUM_EXP = vars.getBoolean("ACCOUNT_PREMIUM_EXP");
		ACCOUNT_PREMIUM_MONEY = vars.getBoolean("ACCOUNT_PREMIUM_MONEY");
		ACCOUNT_PREMIUM_DROP = vars.getBoolean("ACCOUNT_PREMIUM_DROP");
		ACCOUNT_PREMIUM_QUEST = vars.getBoolean("ACCOUNT_PREMIUM_QUEST");

		SERVER_NAME_TEMPLATE = vars.getString("SERVER_NAME_TEMPLATE");
		SERVER_ONLINE_FILE = vars.getString("SERVER_ONLINE_FILE", Strings.EMPTY);

		SERVER_PLAYER_SUB_ID = vars.getInteger("SERVER_PLAYER_SUB_ID");
		SERVER_NPC_SUB_ID = vars.getInteger("SERVER_NPC_SUB_ID");
		SERVER_ITEM_SUB_ID = vars.getInteger("SERVER_ITEM_SUB_ID");
		SERVER_SHOT_SUB_ID = vars.getInteger("SERVER_SHOT_SUB_ID");
		SERVER_OBJECT_SUB_ID = vars.getInteger("SERVER_OBJECT_SUB_ID");
		SERVER_TRAP_SUB_ID = vars.getInteger("SERVER_TRAP_SUB_ID");
		SERVER_RESOURSE_SUB_ID = vars.getInteger("SERVER_RESOURSE_SUB_ID");
		SERVER_PORT = vars.getInteger("SERVER_PORT");

		SERVER_RATE_EXP = vars.getFloat("SERVER_RATE_EXP");
		SERVER_PARTY_RATE_EXP = vars.getFloat("SERVER_PARTY_RATE_EXP");
		SERVER_RATE_MONEY = vars.getFloat("SERVER_RATE_MONEY");
		SERVER_RATE_DROP_ITEM = vars.getFloat("SERVER_RATE_DROP_ITEM");
		SERVER_ONLINE_FAKE = vars.getFloat("SERVER_ONLINE_FAKE");

		SERVER_USE_SNIFFER_OPCODE = vars.getBoolean("SERVER_USE_SNIFFER_OPCODE", false);

		WORLD_LIFE_TIME_DROP_ITEM = vars.getInteger("WORLD_LIFE_TIME_DROP_ITEM");
		WORLD_BLOCK_TIME_DROP_ITEM = vars.getInteger("WORLD_BLOCK_TIME_DROP_ITEM");
		WORLD_MIN_ACCESS_LEVEL = vars.getInteger("WORLD_MIN_ACCESS_LEVEL");
		WORLD_PLAYER_THRESHOLD_ATTACKS = vars.getInteger("WORLD_PLAYER_THRESHOLD_ATTACKS");
		WORLD_PLAYER_THRESHOLD_BLOOKS = vars.getInteger("WORLD_PLAYER_THRESHOLD_BLOOKS");
		WORLD_PLAYER_TIME_BATTLE_STANCE = vars.getInteger("WORLD_PLAYER_TIME_BATTLE_STANCE") * 1000;
		WORLD_MAX_DIFF_LEVEL_ON_DROP = vars.getInteger("WORLD_MAX_DIFF_LEVEL_ON_DROP");
		WORLD_WIDTH_REGION = vars.getInteger("WORLD_WIDTH_REGION");
		WORLD_HEIGHT_REGION = vars.getInteger("WORLD_HEIGHT_REGION");
		WORLD_MAXIMUM_ONLINE = vars.getInteger("WORLD_MAXIMUM_ONLINE");
		WORLD_BANK_MAX_SIZE = vars.getInteger("WORLD_BANK_MAX_SIZE");
		WORLD_GUILD_BANK_MAX_SIZE = vars.getInteger("WORLD_GUILD_BANK_MAX_SIZE");
		WORLD_MAX_COLLECT_LEVEL = vars.getInteger("WORLD_MAX_COLLECT_LEVEL");
		WORLD_PLAYER_MAX_LEVEL = vars.getInteger("WORLD_PLAYER_MAX_LEVEL");
		WORLD_CHANCE_DELETE_CRYSTAL = vars.getInteger("WORLD_CHANCE_DELETE_CRYSTAL", 13);

		WORLD_SHOP_PRICE_MOD = vars.getFloat("WORLD_SHOP_PRICE_MOD");

		WORLD_AUTO_LEARN_SKILLS = vars.getBoolean("WORLD_AUTO_LEARN_SKILLS");
		WORLD_PK_AVAILABLE = vars.getBoolean("WORLD_PK_AVAILABLE");
		WORLD_LEARN_ONLY_IMPLEMENTED_SKILLS = vars.getBoolean("WORLD_LEARN_ONLY_IMPLEMENTED_SKILLS");

		DEVELOPER_FORCE_ATTACK_SPEED = vars.getInteger("DEVELOPER_FORCE_ATTACK_SPEED");
		DEVELOPER_DEBUG_CLIENT_PACKETS = vars.getBoolean("DEVELOPER_DEBUG_CLIENT_PACKETS");
		DEVELOPER_DEBUG_SERVER_PACKETS = vars.getBoolean("DEVELOPER_DEBUG_SERVER_PACKETS");
		DEVELOPER_MAIN_DEBUG = vars.getBoolean("DEVELOPER_MAIN_DEBUG");
		DEVELOPER_DEBUG_TARGET_TYPE = vars.getBoolean("DEVELOPER_DEBUG_TARGET_TYPE");
		DEVELOPER_DEBUG_CASTING_SKILL = vars.getBoolean("DEVELOPER_DEBUG_CASTING_SKILL");
		DEVELOPER_DEBUG_MOVING_PLAYER = vars.getBoolean("DEVELOPER_DEBUG_MOVING_PLAYER");
		DEVELOPER_DEBUG_MOVING_NPC = vars.getBoolean("DEVELOPER_DEBUG_MOVING_NPC");
		DEVELOPER_GEO_LOGING = vars.getBoolean("DEVELOPER_GEO_LOGING");

		Loggers.info("Config", "reloaded.");
	}

	private Config() {
		throw new IllegalArgumentException();
	}
}
