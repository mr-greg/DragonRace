package me.dragonrace.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.Channel;

public class RegisterCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {



        if (event.getName().equalsIgnoreCase("inscription")){

            TextChannel inscriptionChannel = event.getGuild().getTextChannelById(992866620437430323L);

            if (event.getChannel() != inscriptionChannel){
                event.reply("Merci de faire votre demande dans le salon adapté.");
            }

            // CHAMPS FORMULAIRE INSCRIPTION
            /*TextInput discordChef = TextInput.create("discord-chef", "Discord Chef Équipe", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setRequired(true)
                    .setPlaceholder("Le pseudo discord exact chef d'équipe (sans le #)")
                    .build(); */

            TextInput minecraftChef = TextInput.create("minecraft-chef", "Pseudo Minecraft Chef", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setRequired(true)
                    .setPlaceholder("Le pseudo Minecraft exact du chef d'équipe")
                    .build();

            TextInput minecraftMembre1 = TextInput.create("minecraft-membre1", "Pseudo Minecraft Membre 1", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setRequired(true)
                    .setPlaceholder("Le pseudo Minecraft exact du premier membre")
                    .build();

            TextInput minecraftMembre2 = TextInput.create("minecraft-membre2", "Pseudo Minecraft Membre 2", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setRequired(true)
                    .setPlaceholder("Le pseudo Minecraft exact du second membre")
                    .build();

            TextInput chaineTwitch = TextInput.create("twitch-chaine", "Chaîne Twitch", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setRequired(true)
                    .setPlaceholder("Chaîne Twitch du chef d'équipe")
                    .build();


            // CREATION DU FORMULAIRE
            Modal modal = Modal.create("inscription-modal", "Inscription DragonRace")
                    .addActionRows(
                            ActionRow.of(minecraftChef),
                            ActionRow.of(minecraftMembre1),
                            ActionRow.of(minecraftMembre2),
                            ActionRow.of(chaineTwitch))
                    .build();

            event.replyModal(modal).queue();

        }
    }
}
