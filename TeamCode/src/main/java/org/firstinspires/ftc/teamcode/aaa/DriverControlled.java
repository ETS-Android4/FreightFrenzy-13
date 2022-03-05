package org.firstinspires.ftc.teamcode.aaa;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="AaaDriverControlled", group = "aaa")
public class DriverControlled extends LinearOpMode {
    private Aaa robot;
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Aaa(this);

        waitForStart();

        while(opModeIsActive()) {
            double drive = - gamepad1.left_stick_y - (gamepad1.right_stick_y * 0.5);
            double turn = gamepad1.right_stick_x*0.3;
            double strafe = gamepad1.left_stick_x;
            robot.setPower(drive+turn+strafe, drive-turn-strafe, drive+turn-strafe, drive-turn+strafe);

            double notflipper = robot.lifter.getPower();
            if(gamepad2.dpad_up) {
                notflipper += 0.008;
                if(notflipper > 0.5) {
                    notflipper = 0.5;
                }
            } else if(gamepad2.dpad_down) {
                notflipper = -0.7;
            } else {
                notflipper = 0;
            }
            robot.lifter.setPower(notflipper);

            double flipper = 0;
            if(gamepad2.right_bumper) {
                flipper = 1;
            } else if(gamepad2.left_bumper) {
                flipper = -1;
            }
            robot.flipper.setPower(flipper);

            double grabber = 0;
            if(gamepad2.a) {
                grabber = 1;
            } else if(gamepad2.b) {
                grabber = -1;
            }
            robot.grabber.setPower(grabber);

            double spinner = gamepad2.left_trigger - gamepad2.right_trigger;
            robot.spinner.setPower(spinner);

            sleep(20);
        }
    }
}
