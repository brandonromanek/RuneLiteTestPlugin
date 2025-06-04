package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

/**
 * A simple plugin that sends a configurable greeting message when the player
 * logs in.
 */
@Slf4j
@PluginDescriptor(
        name = "Login Announcer"
)
public class LoginAnnouncerPlugin extends Plugin
{
        @Inject
        private Client client;

        @Inject
        private LoginAnnouncerConfig config;

        @Override
        protected void startUp() throws Exception
        {
                log.info("Login Announcer started");
        }

        @Override
        protected void shutDown() throws Exception
        {
                log.info("Login Announcer stopped");
        }

        @Subscribe
        public void onGameStateChanged(GameStateChanged gameStateChanged)
        {
                if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
                {
                        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "",
                                config.greeting(), null);
                }
        }

        @Provides
        LoginAnnouncerConfig provideConfig(ConfigManager configManager)
        {
                return configManager.getConfig(LoginAnnouncerConfig.class);
        }
}
