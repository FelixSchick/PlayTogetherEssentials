package de.felixschick.playTogetherEssentials.utils.enums;

import lombok.Getter;

public enum Messages {
    NO_PERMISSIONS("§4You don't have permission to use this action."),
    NO_PLAYER_FOUND("§4No such player found."),;

    public String message;

    Messages(String message) {
        this.message = message;
    }
}
