package DayFour;

//2011 AP Exam FRQ 1
public class Sound {
	private int[] samples;

	// Part a
	public int limitAmplitude(int limit) {
		int numChanged = 0;
		for (int i = 0; i < samples.length; i++) {
			if (samples[i] > limit) {
				samples[i] = limit;
				numChanged++;
			} else if (samples[i] < -limit) {
				samples[i] = -limit;
				numChanged++;
			}
		}

		return numChanged;
	}

	// Part b
	public void trimSilenceFromBeginning() {
		int numRemoved = 0;

		while (samples[numRemoved] == 0) {
			numRemoved++;
		}
		int[] newArray = new int[samples.length - numRemoved];

		// copy stuff from samples to newArray
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = samples[i + numRemoved];
		}
	}

}
