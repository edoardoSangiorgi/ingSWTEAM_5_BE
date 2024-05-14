package it.unife.ingsw202324.Chat.services;

import it.unife.ingsw202324.Chat.entities.Invite;
import it.unife.ingsw202324.Chat.repositories.InviteRepository;

import java.util.List;

public class InviteService {

    private InviteRepository inviteRepository;

    // -- LETTURA --
    public List<Invite> getAll(){
        return inviteRepository.findAll();
    }


    // -- SCRITTURA --
    public void addInvite(Invite invite){
        inviteRepository.save(invite);
    }


    // -- ELIMINAZIONE --
    public void deleteInvite(Invite invite){
        inviteRepository.delete(invite);
    }


    // -- AGGIORNAMENTO --
    public void update(List<Invite> invites){
        for(Invite invite: invites) {
            this.addInvite(invite);
        }
    }
}
