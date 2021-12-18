package disabled.doggy4.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import disabled.doggy4.Robot;

@Autonomous(name="noPark", group="main")
@Disabled
public class Park extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);
        robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        robot.travelFor(400);

        robot.travelFor(100, -0.5);
    }
}
