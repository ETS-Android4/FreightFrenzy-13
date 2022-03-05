package disabled.doggy4.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import disabled.doggy4.Robot;

@TeleOp(name="DataGathering", group="testing")
@Disabled
public class DataGathering extends LinearOpMode {
    public Baloney robot;

    @Override
    public void runOpMode() {
        robot = new Baloney(this);
        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("IMU", robot.imu.getAngularOrientation());
            telemetry.addData("position", robot.currentPosition());

            telemetry.update();
        }
    }
}
