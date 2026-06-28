package musicmanagement;

public class CircularLinkList {

    private Node head;
    private Node tail;
    private Node current;

    public CircularLinkList(Node head, Node tail, Node current) {
        this.head = head;
        this.tail = tail;
        this.current = current;
    }
    public boolean isEmpty() {
        return head == null;
    }

    // Function add
    public void addSong(Song song) {
       Node newNode = new Node(song);
       if (isEmpty()) {
           head = newNode;
           tail = newNode;
           current = newNode; 
           tail.next = head;  
       } else {
           tail.next = newNode;
           tail = newNode;
           tail.next = head;  
       }
   }
    //Function Remove
    public boolean removeSong(String idOrTitle) {
       if (isEmpty()) {
           return false;
       }

       Node currNode = head;
       Node prevNode = tail; 
       boolean found = false;

       // Duyệt danh sách để tìm vị trí node cần xóa
       do {
           if (currNode.data.getId().equalsIgnoreCase(idOrTitle) || 
               currNode.data.getTitle().equalsIgnoreCase(idOrTitle)) {
               found = true;
               break;
           }
           prevNode = currNode;
           currNode = currNode.next;
       } while (currNode != head);

       if (!found) {
           return false; 
       }

       // only 1 bài
       if (head == tail) {
           head = null;
           tail = null;
           current = null;
           return true;
       }

       //code bị xóa => dịch chuyển current sang node kế tiếp
       if (current == currNode) {
           current = currNode.next;
       }

       // xoa Node head
       if (currNode == head) {
           head = head.next;
           tail.next = head; 
       } 
       // xoa Node tail
       else if (currNode == tail) {
           tail = prevNode;
           tail.next = head; 
       } 
       // xoa Node giữa danh sách
       else {
           prevNode.next = currNode.next;
       }

       return true;
   }
    
    //Search Song theo từ khóa 
   public Song searchSong(String keyword) {
       if (isEmpty()) {
           return null;
       }

       Node temp = head;
       String lowerKeyword = keyword.toLowerCase();
       
       do {
           if (temp.data.getId().toLowerCase().contains(lowerKeyword) || 
               temp.data.getTitle().toLowerCase().contains(lowerKeyword) || 
               temp.data.getArtist().toLowerCase().contains(lowerKeyword)) {
               return temp.data; 
           }
           temp = temp.next;
       } while (temp != head);

       return null;
   }
   
   public void viewAllSongs(){
       if(isEmpty()){
           System.out.println("Playlist is empty");
           return;
       }
       Node temp = head;
       
       do{
           System.out.println(temp.data);
           temp = temp.next;
       } while (temp != head);
   }
   
   public Song getCurrentSong(){
       if(current == null){
           return null;
       }
       return current.data;
   }
   
   public Song getNextSong(){
       if(isEmpty()){
           return null;
       }
       
       if(current == null){
           current = head;
       }else{
           current = current.next;
       }
       return current.data;
   }
   //viewAllSongs, getNextSong , getCurrent viet o day
}
