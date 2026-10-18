package de.felixschick.playTogetherEssentials.utils.enums;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.Particle;

public enum PTEParticles {
    CLOUD(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD1(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD2(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD3(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD4(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD5(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD6(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD7(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD8(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD9(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD10(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD11(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD12(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD13(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD14(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD15(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD16(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD17(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD18(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD19(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD20(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD21(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD22(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD23(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD24(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD25(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD26(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD27(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD28(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    CLOUD29(Particle.CLOUD, Material.WHITE_DYE, Component.text("§fClouds everywhere"), Component.text("§7you are the master of the sky")),
    VILLIGER(Particle.HAPPY_VILLAGER, Material.VILLAGER_SPAWN_EGG, Component.text("Trade Master"), Component.text("Villagers really like you")),;

    @Getter
    public Particle particle;
    @Getter
    public Material material;
    @Getter
    public Component title;
    @Getter
    public Component description;

    PTEParticles(Particle particle, Material material, Component title, Component description) {
        this.particle = particle;
        this.material = material;
        this.title = title;
        this.description = description;
    }
}
