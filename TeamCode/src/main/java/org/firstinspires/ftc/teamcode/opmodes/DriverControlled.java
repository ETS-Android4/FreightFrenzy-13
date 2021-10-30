package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

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
            double drive = -gamepad1.left_stick_y;
            robot.setPower(drive);
        }
    }
}
