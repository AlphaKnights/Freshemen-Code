// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RaisingSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.motorConstants;


/** An example command that uses an example subsystem. */
public class Raise extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RaisingSubsystem m_subsystem;
  private final JoystickButton m_button;
  private final Joystick m_joystick;
  /**
   * Creates a new ExampleCommand.
   *    
   * @param subsystem The subsystem used by this command.
   */
  public Raise(RaisingSubsystem subsystem, JoystickButton button, Joystick joystick) {
    m_subsystem = subsystem;
    m_button = button;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_button.getAsBoolean()) {//m_joystick.getRawButton(buttonID)
        if (m_joystick.getRawAxis(motorConstants.joystickAxisRaise) >= 0) {
            m_subsystem.raiseMotor(motorConstants.RaisingSpeed);
        } else {
            m_subsystem.raiseMotor(-1 * motorConstants.RaisingSpeed);
        }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
