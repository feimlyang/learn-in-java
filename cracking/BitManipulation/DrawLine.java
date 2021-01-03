/**
 * DrawLine: A monochrome screen is stored as a single array of bytes, allowing eight consecutive
pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will
be split across rows). The height of the screen, of course, can be derived from the length of the array
and the width. Implement a function that draws a horizontal line from (xl, y) to (x2, y).
The method signature should look something like:
drawLine(byte[] screen, int width, int x1, int x2, int y)
 */
public class DrawLine {
      public static byte[] drawLine(byte[] screen, int width, int x1, int x2, int y){
          int int_x1 = x1/8, int_x2 = x2/8, mod_x1 = x1%8, mod_x2 = x2%8;
          if (int_x1 == int_x2){
              int mask = 0;
              int bit = 0;
              while (bit < 8){
                  mask <<= 1;
                  if (bit >= mod_x1 && bit <= mod_x2){
                      mask += 1;
                  }
                  bit++;
              }
              screen[int_x1 + y*width] = (byte) mask;
          }
          else{
              int mask_x1 = 0, mask_x2 = 0;
              int bit = 0;
              while (bit < 8){
                  mask_x1 <<= 1;
                  mask_x2 <<= 1;
                  if (bit >= mod_x1){
                      mask_x1 += 1;
                  }
                  if (bit <= mod_x2){
                      mask_x2 += 1;
                  }
                  bit++;
              }
              for (int i = int_x1 + 1; i <= int_x2 - 1; i++){
                  screen[i + y*width] = (byte) 0xFF;
              }
            
              screen[int_x1 + y*width]= (byte) mask_x1;
              screen[int_x2 + y*width] = (byte) mask_x2;
          }
          return screen;
      }
      public static void main(String[] args) {
          byte[] screen = new byte[64];
          int width = 8;
          //x1>=0, x2<=width*8
          drawLine(screen, width, 14, 43, 3);
          for (int i = 0; i < screen.length; i++){
              if (i % width == 0) System.out.println();
              System.out.print(Byte.toString(screen[i]) + " ");
          }
      }
}