package japan;

import java.util.*;

public class CodeSignalTest {

    public static void main(String[] args) {
      int[]a=  {25, 2, 3, 57, 38, 41};
      solution(a);
    }

    static int[] solution(int[] a) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int i=0; i<a.length; i++){
            int temp = a[i];
            int pop;
            while(temp!=0){
                pop = temp%10;
                temp = temp/10;

                if(!frequency.containsKey(pop)){
                    frequency.put(pop, 1);
                }else{
                    frequency.put(pop,frequency.get(pop)+1);
                }

                //int[] result =new int[] frequency.size();
            }
        }

        List<Integer> mostOccer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

            if(entry.getValue()>1){
                mostOccer.add(entry.getKey());
            }
            // System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int[] finalResl = mostOccer.stream().mapToInt(i->i).toArray();
        //Integer[] result = (Integer[]) mostOccer.toArray();

        Arrays.sort(finalResl);



        return finalResl;

    }

    static int solution(String beginWord, String endWord, String[] wordList) {
        HashSet<String> hs=new HashSet<>(Arrays.asList(wordList));
        if(!hs.contains(endWord))
        {
            return 0;
        }
        int steps=1;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty())
        {
            int count=q.size();
            for(int i=0;i<count;i++)
            {
                String curr=q.poll();
                char a[]=curr.toCharArray();
                for(int j=0;j<a.length;j++)
                {
                    char temp=a[j];
                    for(char c='a';c<='z';c++)
                    {
                        if(a[j]==c) continue;
                        a[j]=c;
                        String test=new String(a);
                        if(test.equals(endWord)) return steps+1;
                        if(hs.contains(test))
                        {
                            q.add(test);
                            hs.remove(test);
                        }
                    }
                    a[j]=temp;
                }
            }
            steps++;
        }
        return 0;
    }

}
