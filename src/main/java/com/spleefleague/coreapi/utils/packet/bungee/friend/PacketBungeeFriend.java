package com.spleefleague.coreapi.utils.packet.bungee.friend;

import com.spleefleague.coreapi.player.friends.FriendsAction;
import com.spleefleague.coreapi.utils.packet.bungee.PacketBungee;
import com.spleefleague.coreapi.utils.packet.PacketType;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author NickM13
 */
public class PacketBungeeFriend extends PacketBungee {

    public FriendsAction type;
    public UUID sender, receiver;

    public PacketBungeeFriend() {

    }

    public PacketBungeeFriend(FriendsAction type, UUID sender, UUID receiver) {
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
    }

    @Nonnull
    @Override
    public PacketType.Bungee getBungeeTag() {
        return PacketType.Bungee.FRIEND;
    }

}
