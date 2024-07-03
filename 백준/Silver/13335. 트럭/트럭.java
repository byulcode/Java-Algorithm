import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, w, L;
	static Queue<Truck> trucks = new LinkedList<>();
	static List<Truck> onBridge = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int weight = Integer.parseInt(st.nextToken());
			trucks.add(new Truck(weight));
		}

		int time = 0;
		int sum = 0;
		while (!trucks.isEmpty() || !onBridge.isEmpty()) {
			time++;
			// 다리 위에 있는 트럭
			if (!onBridge.isEmpty()) {
				Iterator<Truck> iterator = onBridge.iterator();
				while (iterator.hasNext()) {
					Truck on = iterator.next();
					if (on.idx == w) {
						sum -= on.weight;
						iterator.remove();
					} else {
						on.idx += 1;
					}
				}
			}

			// 다리 위에 올라오려는 트럭
			if (!trucks.isEmpty()) {
				Truck tryTruck = trucks.peek();
				if (sum + tryTruck.weight <= L) {
					sum += tryTruck.weight;
					onBridge.add(trucks.poll());
				}
			}
		}
		System.out.println(time);
	}
}

class Truck {
	int weight;
	int idx;

	public Truck(int weight) {
		this.weight = weight;
		this.idx = 1;
	}
}
