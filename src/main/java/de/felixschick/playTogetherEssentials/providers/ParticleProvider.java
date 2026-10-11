package de.felixschick.playTogetherEssentials.providers;

import de.felixschick.playTogetherEssentials.PlayTogetherEssentials;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class ParticleProvider {
    private final PlayTogetherEssentials plugin;

    public ArrayList<UUID> particlePlayers = new ArrayList<>();

    public ParticleProvider(PlayTogetherEssentials plugin) {
        this.plugin = plugin;

        startParticleJob();
    }

    private void startParticleJob() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                for (UUID uuid : particlePlayers) {
                    Player player = Bukkit.getPlayer(uuid);
                    if (player != null) {
                        playParticle(player, player.getLocation());
                    } else  {
                        particlePlayers.remove(uuid);
                    }
                }
            }
        }, 0L, 1L);
    }

    public void addPlayer(Player player) {
        particlePlayers.add(player.getUniqueId());
    }

    public void removePlayer(Player player) {
        particlePlayers.remove(player.getUniqueId());
    }

    public void toggleParticle(Player player) {
        if (particlePlayers.contains(player.getUniqueId())) {
            particlePlayers.remove(player.getUniqueId());
        } else
            particlePlayers.add(player.getUniqueId());
    }

    public void playParticle(Player player, Location center) {
        double radius = 2.0; // The radius of the circle in blocks
        int points = 64;     // How many points/coordinates make up the circle

        for (int i = 0; i < points; i++) {
            double angle = 2 * Math.PI * i / points;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            double y = center.getY();

            Location pointLocation = new Location(center.getWorld(), x, y, z);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.PURPLE, 1F);
            player.spawnParticle(Particle.DUST, pointLocation, 1, dustOptions);
        }

    }
}
