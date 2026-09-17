package com.drtshock.playervaults.vaultmanagement;

import org.bukkit.OfflinePlayer;

import java.util.UUID;
import java.util.function.Function;

public final class HarmVaults {

    public static Function<UUID, Integer> ROWS_FUNCTION = null;

    public static int getRows(UUID uuid) {
        if (ROWS_FUNCTION == null) return 0;
        return ROWS_FUNCTION.apply(uuid);
    }

    public static int getRows(OfflinePlayer player) {
        return getRows(player.getUniqueId());
    }

    public static Integer getRowsForMenu(int unlockedRows, int menuNumber) {
        int startIndex = (menuNumber - 1) * 6;

        if (unlockedRows <= startIndex) {
            return null;
        }

        int remainingRows = unlockedRows - startIndex;
        return Math.min(6, remainingRows);
    }
}
