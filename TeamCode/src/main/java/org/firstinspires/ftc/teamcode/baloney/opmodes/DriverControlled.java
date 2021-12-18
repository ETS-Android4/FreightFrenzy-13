package org.firstinspires.ftc.teamcode.baloney.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

@TeleOp(name="DriverControlled", group="baloney")
public class DriverControlled extends LinearOpMode {

    // Declare OpMode members.
    private Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            double drive = (-gamepad1.left_stick_y)+ (0.25 * -gamepad1.right_stick_y);
            double turn = gamepad1.right_stick_x * 0.25 + gamepad1.left_stick_x;

            robot.setPower(drive+turn, drive-turn);
          
            double extend = robot.lifter.getPower();
            if(gamepad2.dpad_down) {
                robot.lifter.setPower(Math.min(extend + 0.05, 0.7));
                sleep(50);
            } else if(gamepad2.dpad_up) {
                robot.lifter.setPower(Math.max(extend - 0.05, -0.4));
                sleep(50);
            } else {
                robot.lifter.setPower(0);
            }
          
            double grab = 0.0;
            boolean flag = true;
            if(gamepad2.right_bumper) {
                grab = -1.0;
            } else if(gamepad2.left_bumper) {
                grab = 1.0;
            } else if(gamepad2.a) {
                grab = 0.0;
            } else {
                flag = false;
            }
            if(flag) {
                telemetry.addData("grabber", grab);
                telemetry.update();
                robot.grabber.setPower(grab);
            }

            robot.spinner.setPower(gamepad2.right_trigger-gamepad2.left_trigger);

        }
    }
}
