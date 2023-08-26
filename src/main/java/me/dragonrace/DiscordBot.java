package me.dragonrace;

import me.dragonrace.commands.EmbedCommand;
import me.dragonrace.listeners.ButtonRegisterListener;
import me.dragonrace.listeners.InscriptionListener;
import me.dragonrace.listeners.RegisterModalListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static void main(String[] args) throws LoginException, InterruptedException {

        JDA bot = JDABuilder.createDefault(Config.get("TOKEN")).setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_PRESENCES)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .enableIntents(GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.competing("Dragon Race"))
                .addEventListeners(new ButtonRegisterListener())
                .addEventListeners(new EmbedCommand())
                .addEventListeners(new InscriptionListener())
                .addEventListeners(new RegisterModalListener())
                .build().awaitReady();

        Guild guild = bot.getGuildById(950342499166216192L);
        if (guild != null){
            guild.upsertCommand("inscription", "Inscription au prochain Event").queue();
            guild.upsertCommand("embed", "Ajout d'un embed").queue();
        }
    }
}
