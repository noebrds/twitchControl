package com.noe.twitchControl.config;

import com.noe.twitchControl.util.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = Reference.MOD_ID, name = "twitchControl_config", type = Type.INSTANCE)
public class ConfigClass {
	
	@Name("Your twitch chat token")
	@Comment("Put your twitch chat token. You can found it here: https://twitchapps.com/tmi/")
	public static String token = "null";
	
	@Name("Your twitch channel name")
	public static String channel = "ChannelExemple";
	
}
