package disabled.doggy4.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import disabled.doggy4.Robot;

@TeleOp(name="asdfghjkl", group="main")
@Disabled
public class DriverControlled extends LinearOpMode {

    // Declare OpMode members.
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            double drive = (-gamepad1.left_stick_y)+ (0.25 * -gamepad1.right_stick_y);
            double turn = gamepad1.right_stick_x * 0.25 + gamepad1.left_stick_x;
            double strafe = gamepad1.right_trigger - gamepad1.left_trigger;

            robot.setPower(
                    drive + turn - strafe,
                    drive - turn + strafe,
                    drive + turn + strafe,
                    drive - turn - strafe);
          
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
                telemetry.addData("grabber", grab);
                telemetry.update();
                robot.grabber.setPower(grab);
            }

            if (gamepad2.right_trigger > 0) {
                robot.spinner.setPower(gamepad2.right_trigger);
            } else if (gamepad2.left_trigger > 0) {
                robot.spinner.setPower(-gamepad2.left_trigger);
            } else
                robot.spinner.setPower(0);

        }
    }
}
