package com.spleefleague.coreapi.utils.packet.bungee.party;

import com.spleefleague.coreapi.party.PartyAction;
import com.spleefleague.coreapi.utils.packet.bungee.PacketBungee;
import com.spleefleague.coreapi.utils.packet.PacketType;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author NickM13
 */
public class PacketBungeeParty extends PacketBungee {

    public PartyAction type;
    public UUID sender, target;

    public PacketBungeeParty() {

    }

    public PacketBungeeParty(PartyAction type, UUID sender) {
        this.type = type;
        this.sender = sender;
        this.target = null;
    }

    public PacketBungeeParty(PartyAction type, UUID sender, UUID target) {
        this.type = type;
        this.sender = sender;
        this.target = target;
    }

    @Nonnull
    @Override
    public PacketType.Bungee getBungeeTag() {
        return PacketType.Bungee.PARTY;
    }

}
