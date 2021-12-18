package org.firstinspires.ftc.teamcode.baloney;

import com.qualcomm.robotcore.hardware.Gamepad;

public class DbGamepadHandler {
    private Gamepad gamepad;
    private boolean wasADown;

    public DbGamepadHandler(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void update() {
        wasADown = gamepad.a;
    }

    public boolean wasPressed(Button button) {
        return gamepad.a && !wasADown;
    }

    enum Button {
        A
    }
}
