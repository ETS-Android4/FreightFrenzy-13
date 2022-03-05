package org.firstinspires.ftc.teamcode.aaa;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="AaaServo", group = "aaa")
public class Servo extends LinearOpMode {
    private Aaa robot;
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Aaa(this);

        waitForStart();

        com.qualcomm.robotcore.hardware.Servo servo = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "flipper");


        while(opModeIsActive()) {
            double pos = 0;
            if(gamepad1.dpad_up) {
                pos += 0.05;
            } else if(gamepad1.dpad_down) {
                pos -= 0.05;
            }

            telemetry.addData("pos", pos);
            telemetry.update();
            servo.setPosition(pos);

            sleep(50);
        }
    }
}
