.data 
.align 2
string_to_modify: .space 40
prefix: .asciiz "You typed: "
prompt: .asciiz "Enter a string: "
result: .word 5

.text
.globl main 

main:
        

        addi    $a0, $sp, 16
        jal     PrintString
        b       Lmain_end

Lmain_end:
        lw      $ra, 88($sp)
        lw      $s7, 84($sp)
        lw      $s6, 80($sp)
        lw      $s5, 76($sp)
        lw      $s4, 72($sp)
        lw      $s3, 68($sp)
        lw      $s2, 64($sp)
        lw      $s1, 60($sp)
        lw      $s0, 56($sp)
        addiu   $sp, $sp, 92
        jr      $ra
        

 generate_echo_string:  
 
  addi $sp, $sp, -56
  sw $s1, 48($sp)
  sw $s0, 44($sp)
  sw $a0, 40($sp) # this would be the address of the string to modify which you should use in char starting point
  sw $a1, 36($sp)
  sw $t1, 32($sp)
  sw $s3, 28($sp)
  sw $s4, 24($sp)
  sw $s5, 20($sp)
  sw $s6, 16($sp)
 
  # 00400078
  
  lw $s5, 40($sp) # char string to modify
  lw $t1, 36($sp) # int max bytes
  
  subi $s6, $t1, 1 # max bytes - 1 
  add $s6, $s5, $s6 # address to store
  sb $zero, ($s6) 

  # int prefix_length = strlen(prefix);
  
  la $a0, prefix
  jal strlen
  move $t5, $v0
  
  # strncpy(string_to_modify, prefix, max_bytes - 1);
  
  subi $s3, $t1, 1
  
  la $a0, ($s5)
 # la $a0, ($s5)
  la $a1, prefix
  move $a2, $s3
  jal strncpy # this has you typed, this is accurate
  
  
  #  if (prefix_length >= max_bytes)
  bge $t5, $t1, used_up
  
  # char * starting_point = string_to_modify + prefix_length;
 
  add $s4, $s5, $t5
  
  # max_bytes - prefix_length 
  
  sub $t6, $t1, $t5
  
  # InputConsoleString(prompt, starting_point, max_bytes - prefix_length);
  
  la $a0, prompt #works
  la $a1, ($s4)
  la $a2, ($t6)
  jal InputConsoleString

used_up:

  move $v0, $s5
  la      $a0, ($s5)
  jal     PrintString
 
  lw $ra, 52($sp)
  lw $s1, 48($sp)
  lw $s0, 44($sp)
  lw $a0, 40($sp) 
  lw $a1, 36($sp)
  lw $t1, 32($sp)
  lw $s3, 28($sp)
  lw $s4, 24($sp)
  lw $s5, 20($sp)
  lw $s6, 16($sp)
  subi $sp, $sp, -56
   
  li $v0, 10
  syscall 
   
 # jr $ra

 .include "./util.s"
