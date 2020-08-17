package com.noe.twitchControl.twitchBot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import org.jibble.pircbot.PircBot;

import com.noe.twitchControl.twitchControlEventHandler;

import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MoverType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import scala.swing.event.MouseButtonEvent;

public class Bot extends PircBot{
	
	
	public Bot() {
		this.setName("BobLeBot");
		
		this.isConnected();

		
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		
		
		
		sendMessage(channel, "Hello, I'm a bot");
		
		if (message.startsWith("!")) {
			
			
			if (message.equalsIgnoreCase("!jump")) {
				twitchControlEventHandler.player.jump();
			}
			
			
			if (message.equalsIgnoreCase("!walk")) {
				
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_W);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			
			if (message.equalsIgnoreCase("!notwalk")) {
				try {
					Robot robot = new Robot();
					robot.keyRelease(KeyEvent.VK_W);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			
			if (message.equalsIgnoreCase("!bigwalk")) {
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_W);
					robot.keyPress(KeyEvent.VK_SHIFT);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			
			
			
			if (message.equalsIgnoreCase("!flower")) {

				try {
					Robot robot = new Robot();
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				
			}
			
			if (message.equalsIgnoreCase("!left")) {
				Minecraft.getMinecraft().player.setPositionAndRotation(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ, Minecraft.getMinecraft().player.rotationYaw + 10, Minecraft.getMinecraft().player.rotationPitch);
			}
			
			if (message.equalsIgnoreCase("!notleft")) {
				Minecraft.getMinecraft().player.setPositionAndRotation(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ, Minecraft.getMinecraft().player.rotationYaw - 10, Minecraft.getMinecraft().player.rotationPitch);
			}
			
			if (message.equalsIgnoreCase("!sky")) {
					Minecraft.getMinecraft().player.setPositionAndRotation(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ, Minecraft.getMinecraft().player.rotationYaw, Minecraft.getMinecraft().player.rotationPitch + 10);		
			}
			
			if (message.equalsIgnoreCase("!rim")) {
				Minecraft.getMinecraft().player.setPositionAndRotation(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ, Minecraft.getMinecraft().player.rotationYaw, Minecraft.getMinecraft().player.rotationPitch - 10);
			}
			
			if (message.equalsIgnoreCase("!mine")) {
				try {
					Robot robot = new Robot();
					robot.mousePress(InputEvent.BUTTON1_MASK);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			
			if (message.equalsIgnoreCase("!craft")) {
				try {
					Robot robot = new Robot();
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
			
			if (message.equalsIgnoreCase("!use")) {
				try {
					Robot robot = new Robot();
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (AWTException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
