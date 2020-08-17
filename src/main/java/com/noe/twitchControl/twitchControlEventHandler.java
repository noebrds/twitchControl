package com.noe.twitchControl;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.jibble.pircbot.IrcException;

import com.noe.twitchControl.config.ConfigClass;
import com.noe.twitchControl.twitchBot.Bot;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class twitchControlEventHandler {
	
	Bot bot = new Bot();
	public static EntityPlayer player;
	public static EntityLivingBase playerLivingBase;

	
	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			player = (EntityPlayer) event.getEntity();
			playerLivingBase = (EntityLivingBase) event.getEntity();			
			
			String channel = "#" + ConfigClass.channel.toLowerCase();
			
			
					
		if (!bot.isConnected()) {			
					bot.setVerbose(true);
					try {
						bot.connect("irc.twitch.tv", 6667, ConfigClass.token);
					} catch (IOException | IrcException e) {
						e.printStackTrace();
					}
					bot.joinChannel(channel);
					bot.getName();
			}
					
		}
		

		
		
	}
	
	@SubscribeEvent
	public void playerRespawn(PlayerRespawnEvent event) {
		player = event.player;
	}
	
}
