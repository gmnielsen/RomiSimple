// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class TaddDrive extends CommandBase {
  double left;
  double right;
  RomiDrivetrain m_drive;
  /** Creates a new TaddDrive. */
  public TaddDrive(double LeftDistance, double RightDistance, RomiDrivetrain drivetrain) {
    left=LeftDistance;
    right=RightDistance;
    m_drive = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.tankDriveVolts(0.5, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.fullStop();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_drive.getLeftDistanceInch()>left;
  }
}