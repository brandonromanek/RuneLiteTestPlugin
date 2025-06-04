package com.example;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class LoginAnnouncerPluginTest
{
        public static void main(String[] args) throws Exception
        {
                ExternalPluginManager.loadBuiltin(LoginAnnouncerPlugin.class);
                RuneLite.main(args);
        }
}
