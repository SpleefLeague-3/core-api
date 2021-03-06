package com.spleefleague.coreapi.utils.packet.spigot.battle;

import com.spleefleague.coreapi.database.variable.DBPlayer;
import com.spleefleague.coreapi.utils.packet.spigot.PacketSpigot;
import com.spleefleague.coreapi.utils.packet.PacketType;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author NickM13
 * @since 9/18/2020
 */
public class PacketSpigotBattleSpectate extends PacketSpigot {

    public UUID spectator;
    public UUID target;

    public PacketSpigotBattleSpectate() { }

    public PacketSpigotBattleSpectate(DBPlayer spectator, DBPlayer target) {
        this.spectator = spectator.getUniqueId();
        this.target = target.getUniqueId();
    }

    @Nonnull
    @Override
    public PacketType.Spigot getSpigotTag() {
        return PacketType.Spigot.BATTLE_SPECTATE;
    }

}
