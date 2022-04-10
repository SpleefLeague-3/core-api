package com.spleefleague.coreapi.game.leaderboard;

import com.spleefleague.coreapi.player.statistics.Rating;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * @author NickM13
 * @since 4/10/2022
 */
public class LeaderboardTest {

    @Test
    public void givenLeaderboardScores_whenSetScore_thenReturnRankingAndScore() {
        Leaderboard leaderboard = new Leaderboard("test", "1");
        String expectedName = "test";
        String expectedSeason = "1";

        Assert.assertEquals(expectedName, leaderboard.getName());
        Assert.assertEquals(expectedSeason, leaderboard.getSeason());
        Assert.assertNull(leaderboard.getCreateTime());

        UUID playerUuid1 = UUID.randomUUID();
        UUID playerUuid2 = UUID.randomUUID();

        Rating playerRating1 = new Rating();
        playerRating1.setElo(2000);
        for (int i = 0; i < 10; i++) playerRating1.addWin();
        playerRating1.updateDivision();

        Rating playerRating2 = new Rating();
        playerRating2.addElo(50);
        for (int i = 0; i < 10; i++) playerRating2.addLoss();
        playerRating2.updateDivision();

        leaderboard.setPlayerScore(playerUuid1, "player1", playerRating1);
        playerRating1.addElo(50);
        leaderboard.setPlayerScore(playerUuid1, "player1", playerRating1);
        leaderboard.setPlayerScore(playerUuid2, "player2", playerRating2);

        Assert.assertEquals(0, leaderboard.getPlayerRanking(playerUuid1));
        Assert.assertEquals(1, leaderboard.getPlayerRanking(playerUuid2));

        Assert.assertEquals(2050, leaderboard.getPlayerScore(playerUuid1));
        Assert.assertEquals(1050, leaderboard.getPlayerScore(playerUuid2));

        Assert.assertEquals(2, leaderboard.getPlayerCount());

        Assert.assertTrue(leaderboard.containsPlayer(playerUuid1));
        Assert.assertFalse(leaderboard.containsPlayer(UUID.randomUUID()));

        List<Leaderboard.LeaderboardEntry> entries = leaderboard.getPlayers(0, 1);

        Assert.assertEquals(playerUuid1, entries.get(0).getUniqueId());
        Assert.assertEquals("player1", entries.get(0).getUsername());
        Assert.assertEquals(2050, entries.get(0).getElo());
        Assert.assertEquals(Rating.Division.PLATINUM2, entries.get(0).getDivision());
        Assert.assertEquals(11, entries.get(0).getWins());
        Assert.assertEquals(0, entries.get(0).getLosses());
        Assert.assertEquals(0, entries.get(0).getLastDecay());

        playerRating1.addElo(25);
        entries.get(0).update(playerRating1);
        leaderboard.setPlayerScore(playerUuid1, entries.get(0));
    }

}
