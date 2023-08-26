package me.dragonrace.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class EmbedCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("embed")){
            EmbedBuilder eb = new EmbedBuilder();

            // TITRE
            eb.setTitle("Inscription BedWars", null);

            // COULEUR
            eb.setColor(Color.PINK);
            eb.setColor(new Color(0xFFC0CB));
            eb.setColor(new Color(255, 105, 180));

            // DESCRIPTION
            eb.setDescription("**Vendredi 22 juillet** à partir de **20H** aura lieu une soirée **BedWars** !" +
                    "\n\nSi vous souhaitez y participer, n'hésitez pas à vous inscrire en cliquant sur le bouton ci-dessous." +
                    "\n\n*Les teams seront tirées au sort (si vous souhaitez absolument jouer avec quelqu'un, vous pourrez le préciser dans le formulaire d'inscription !*");

            // AUTEUR
            // eb.setAuthor("Zaack", null, null);

            Button inscriptionBouton = Button.success("inscription-bouton", "S'inscrire");
            Button desinscriptionBouton = Button.danger("desinscription-bouton", "Se désinscrire");

            Message message = new MessageBuilder()
                    .setEmbeds(eb.build())
                    .setActionRows(ActionRow.of(inscriptionBouton, desinscriptionBouton))
                    .build();

            event.getChannel().sendMessage(message).queue();
        }

    }
}
