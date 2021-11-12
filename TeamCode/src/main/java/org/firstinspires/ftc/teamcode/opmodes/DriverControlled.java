package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="DriverControlled", group="Linear Opmode")
public class DriverControlled extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Robot robot;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot = new Robot(this);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y-gamepad1.right_stick_y;
            double turn = gamepad1.left_stick_x;
            double strafe = gamepad1.right_stick_x;
            robot.setPower(drive+turn-strafe, drive-turn+strafe, drive+turn+strafe, drive-turn-strafe);

            double extend = robot.lifter.getPower();
            if(gamepad2.dpad_up) {
                extend += 0.05;
                if(extend > 0.7) {
                    extend = 0.7;
                }
                sleep(50);
            } else if(gamepad2.dpad_down) {
                extend -= 0.05;
                if(extend < -0.3) {
                    extend = -0.3;
                }
                sleep(50);
            } else {
                extend = 0.0;
            }
            robot.lifter.setPower(extend);

            double grab = 0.0;
            boolean flag = true;
            if(gamepad2.dpad_right) {
                grab = -1.0;
            } else if(gamepad2.dpad_left) {
                grab = 1.0;
            } else if(gamepad2.a) {
                grab = 0.0;
            } else {
                flag = false;
            }
            if(flag) {
                robot.grabber.setPower(grab);
            }

            double spin = 0.0;
            if(gamepad2.right_bumper) {
                spin = 1.0;
            } else if(gamepad2.left_bumper) {
                spin = -1.0;
            }
            robot.spinner.setPower(spin);

        }
    }
}
