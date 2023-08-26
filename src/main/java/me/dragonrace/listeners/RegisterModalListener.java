package me.dragonrace.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class RegisterModalListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {

        if (event.getModalId().equals("inscription-modal")){

            String minecraftChef = event.getValue("minecraft-chef").getAsString();
            String minecraftMembre1 = event.getValue("minecraft-membre1").getAsString();
            // String minecraftMembre2 = event.getValue("minecraft-membre2").getAsString();
            // String chaineTwitch = event.getValue("twitch-chaine").getAsString();

            Member inscrit = event.getMember();
            String idInscrit = Objects.requireNonNull(event.getMember()).getId();

            // CHANGER L'ID DU SALON POUR LE SALON STAFF ICI
            TextChannel staff = event.getGuild().getTextChannelById(991007837499043920L);
            if (staff == null) return;

            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("Nouvelle inscription !", null);

            eb.setColor(Color.PINK);
            eb.setColor(new Color(0xFFC0CB));
            eb.setColor(new Color(255, 105, 180));

            eb.setDescription(
                    "<@" + idInscrit + "> s'est inscrit !" +
                    "\nSon pseudo Minecraft : " + minecraftChef + "" +
                    "\nPseudo Minecraft de son coéquipier : \"" + minecraftMembre1 + "\"" );

            // LE ROLE DONNE LORS DE L'INSCRIPTION A CHANGER
            Role confirme = event.getGuild().getRoleById(993558225066659980L);

            staff.sendMessageEmbeds(eb.build()).queue();
            event.reply("Votre inscription a bien été prise en compte, vous avez maintenant accès au salon de participants !").setEphemeral(true).queue();
            event.getGuild().addRoleToMember(inscrit, confirme).queue();

            // event.getMember().getRoles().add(confirme);





        }
    }
}
