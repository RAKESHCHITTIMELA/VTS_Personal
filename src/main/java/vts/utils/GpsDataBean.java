package vts.utils;

public class GpsDataBean {
	private float x;
	private float y;
	private long t;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public long getT() {
		return t;
	}

	public void setT(long t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "GpsDataBean [x=" + x + ", y=" + y + ", t=" + t + "]";
	}

}
