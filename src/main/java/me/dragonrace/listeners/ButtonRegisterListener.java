package me.dragonrace.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import org.jetbrains.annotations.NotNull;


public class ButtonRegisterListener extends ListenerAdapter {

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        // BOUTON INSCRIPTION

        if (event.getButton().getId().equals("inscription-bouton")){
            TextChannel inscriptionChannel = event.getGuild().getTextChannelById(993555973832708178L);

            TextInput minecraftChef = TextInput.create("minecraft-chef", "Votre pseudo Minecraft", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setMaxLength(30)
                    .setRequired(true)
                    .setPlaceholder("Votre pseudo Minecraft exact pour la whitelist !")
                    .build();

            TextInput minecraftMembre1 = TextInput.create("minecraft-membre1", "Coéquipier optionnel", TextInputStyle.SHORT)
                    .setMinLength(1)
                    .setMaxLength(30)
                    .setRequired(false)
                    .setPlaceholder("Pseudo Minecraft de votre teammate (optionnel")
                    .build();


            // CREATION DU FORMULAIRE
            Modal modal = Modal.create("inscription-modal", "Inscription BedWars")
                    .addActionRows(
                            ActionRow.of(minecraftChef),
                            ActionRow.of(minecraftMembre1))
                    .build();

            event.replyModal(modal).queue();

        } else if (event.getButton().getId().equals("desinscription-bouton")){
            Member membre = event.getMember();
            // CHANGER ICI
            Role confirme = event.getGuild().getRoleById(993558225066659980L);
            TextChannel staff = event.getGuild().getTextChannelById(991007837499043920L);


            event.getGuild().removeRoleFromMember(membre, confirme).queue();
            event.reply("Tu as bien été désinscrit de l'évènement.").setEphemeral(true).queue();

            staff.sendMessage(membre.getAsMention() + " s'est désinscrit de l'évènement en cours.").queue();
        }
    }
}
