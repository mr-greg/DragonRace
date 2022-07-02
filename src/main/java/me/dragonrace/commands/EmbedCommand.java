package me.dragonrace.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class EmbedCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("embed")){
            EmbedBuilder eb = new EmbedBuilder();

            // TITRE
            eb.setTitle("Inscription DragonRace", null);

            // COULEUR
            eb.setColor(Color.PINK);
            eb.setColor(new Color(0xFFC0CB));
            eb.setColor(new Color(255, 105, 180));

            // DESCRIPTION
            eb.setDescription("Afin de vous inscrire au prochain DragonRace, veuillez utiliser la commande :" +
                    "\n\n `/inscription`" +
                    "\n\nNous vous remercions de vous inscrire **UNIQUEMENT** si vous êtes **100% SÛR** de pouvoir être **PRÉSENT** !" +
                    "\n\n*En cas de désistement, merci de contacter @Mauc en MP le plus tôt possible, toute annulation abusive pourra se voir" +
                    " bannir des prochains évènements.*");

            // AUTEUR
            // eb.setAuthor("Zaack", null, null);


            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }

    }
}
