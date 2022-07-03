package me.dragonrace.listeners;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InscriptionListener extends ListenerAdapter {

    // SUPPRIME LES MESSAGES AUTRE QUE LA COMMANDE /INSCRIPTION DANS LE SALON
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel inscription = event.getGuild().getTextChannelById(992866620437430323L);
        Message message = event.getMessage();
        if (event.getAuthor().isBot()) return;
        if (event.getTextChannel().equals(inscription) && !message.getContentRaw().equals("/inscription")){
            message.delete().queue();
        }
    }
}
