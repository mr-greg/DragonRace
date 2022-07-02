package me.dragonrace;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault(Config.get("TOKEN"))
                .setActivity(Activity.competing("Dragon Race"))
                .build();

    }
}
