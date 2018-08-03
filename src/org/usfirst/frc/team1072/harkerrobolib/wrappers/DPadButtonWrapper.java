package org.usfirst.frc.team1072.harkerrobolib.wrappers;

import edu.wpi.first.wpilibj.GenericHID;

public class DPadButtonWrapper extends ButtonWrapper {

	private final GenericHID m_joystick;
	private final int m_degrees;
	
	public DPadButtonWrapper(GenericHID joystick, int degrees) {
		m_joystick = joystick;
		m_degrees = degrees;
	}
	
	@Override
	public boolean get() {
		return m_joystick.getPOV() == m_degrees;
	}

}
