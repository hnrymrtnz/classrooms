import java.util.Stack;

public class MelodyQueue 
{
	//Creates two nodes, one for front and one for back of queue.
	Node front;
	Node back;

	//Initializes front and back nodes.
	public MelodyQueue()
	{
		front = null;
		back = null;
	}
   
	public void enqueue(Object  item)
	{
		Node newNode = new Node(item);

		if(back == null)
		{
			front = newNode;
         	back = newNode;
		}
		else
		{
			back.setNext(newNode);
			back = newNode;
		}
	}

	public Object dequeue()
	{
		if(back == null)
		{
			return "Queue is null.";
		}
		else if(front == back)
		{
			Node temp = front;

			front = null;
			back = null;

			return temp;
		}
		else
		{
			Node temp = front;

			front = front.getNext();

			return temp;
		}
	}

	public Boolean isEmpty()
	{
		if(back == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public double duration()
	{
		double total = 0.0;
		Node current = front;

		while(current != null)
		{
			if(((Note) current.getItem()).isRepeat())
			{
				do 
				{
					current = current.getNext();
				} while(!(((Note) current.getItem()).isRepeat()));

				current = current.getNext();
			}
			else
			{
				total = total + ((Note) current.getItem()).getDuration();
				current = current.getNext();
			}
		}

		return total + timeRepeat();
	}

	public double timeRepeat()
	{
		double total = 0.0;
		Node current = front;

		while(current != null)
		{
			if(((Note) current.getItem()).isRepeat())
			{
				do 
				{
					total = total + (((Note) current.getItem()).getDuration() * 2);
					current = current.getNext();
				} while(!(((Note) current.getItem()).isRepeat()));

				total = total + (((Note) current.getItem()).getDuration() * 2);
				current = current.getNext();
			}
			else
			{
				current = current.getNext();
			}
		}

		return total;
	}

	public int size()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			Node current = front;
			int count = 0;

			while(current != null)
			{
				count++;
				current = current.getNext();
			}

			return count;
		}
	}

	public String makeString()
	{
		if(front == back)
		{
			return ((Note) front.getItem()).toString();
		}
		else
		{
			Node current = front;
			String notes = "";
			while(current != null)
			{
				Note note = ((Note) current.getItem());
				notes = notes + note.toString() + "\n";
				current = current.getNext();
			}
			return notes; 
		}
	}

	public void tempoChange(double tempo)
	{
		Node current = front;

		while(current != null)
		{
			Note note = ((Note) current.getItem());
			note.setDuration(note.getDuration() * tempo);

			current = current.getNext();
		}
	}

	public void playRepeat()
	{
		Node current = front;
		int repeat = 2;

		while(repeat > 0)
		{
			while(current != null)
			{
				((Note) current.getItem()).play();
				current = current.getNext();
			}

			current = front;
			repeat--;
		}
	}

	public void appendMelody(MelodyQueue other)
	{
		MelodyQueue temp = other;

		Node current = temp.front;

		while(current != null)
		{
			back.setNext(current);
			back = current;
			current = current.getNext();
		}
	}

	public MelodyQueue reverseMelody()
	{
		Stack<Note> stack = new Stack<Note>();
		MelodyQueue reverse = new MelodyQueue();

		Node current = front;

		while(current != null)
		{
			stack.push((Note) current.getItem());
			current = current.getNext();
		}

		while(!(stack.empty()))
		{
			reverse.enqueue(stack.pop());
		}

		return reverse;
	}

	public void play()
	{
		Node current = front;

		while(current != null)
		{
			if(((Note) current.getItem()).isRepeat())
			{
				MelodyQueue temp = new MelodyQueue();
				temp.enqueue((Note) current.getItem());
				current = current.getNext();

				while(!(((Note) current.getItem()).isRepeat()))
				{
					temp.enqueue((Note) current.getItem());
					current = current.getNext();
				}

				temp.enqueue((Note) current.getItem());

				temp.playRepeat();

				current = current.getNext();
			}
			else
			{
				((Note) current.getItem()).play();
				current = current.getNext();
			}
		}
	}
   }