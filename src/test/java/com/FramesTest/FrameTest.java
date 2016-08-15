package com.FramesTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Frames.HandlingFrames;
import com.commonTest.TestBase;

public class FrameTest extends TestBase {

	@Test
	public void TestFrames() throws IOException {

		HandlingFrames hFrame = new HandlingFrames(getDriver1(), "Raj",
				"Thirumalasetti");
		hFrame.naviGateURL();
		hFrame.HandleFirstFrame();
		hFrame.setBackFrame();
		hFrame.HandleSeconFrame();

		Assert.assertEquals(true, true);
	}

}
