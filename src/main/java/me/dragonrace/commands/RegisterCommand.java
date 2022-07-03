package me.dragonrace.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.Channel;

public class RegisterCommand extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        // BOUTON INSCRIPTION

        if (event.getButton().getId().equals("inscription-bouton")){
            TextChannel inscriptionChannel = event.getGuild().getTextChannelById(992866620437430323L);

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

        } else if (event.getButton().getId().equals("desinscription-bouton")){
            Member membre = event.getMember();
            Role confirme = event.getGuild().getRoleById(992899372838817912L);
            TextChannel staff = event.getGuild().getTextChannelById(992866238894190712L);


            event.getGuild().removeRoleFromMember(membre, confirme).queue();
            event.reply("Tu as bien été désinscrit de l'évènement.").setEphemeral(true).queue();

            staff.sendMessage(membre.getAsMention() + " s'est désinscrit de l'évènement en cours.").queue();
        }
    }
}
