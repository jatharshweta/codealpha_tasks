from scapy.all import sniff, IP, TCP, UDP

def pkt_received(packet):
    if IP in packet:
        print("Waiting for packet...")
        print(f"Packet received from {packet[IP].src} to {packet[IP].dst}")
        if TCP in packet:
            print("Protocol: TCP")
        elif UDP in packet:
            print("Protocol: UDP")
        else:
            print("Protocol: Other")
        print("Hello from sender!\n")
        return True  # This will be used by stop_filter to stop sniffing

print("Sniffer started...")
# stop_filter stops sniffing when the function returns True
sniff(store=False, stop_filter=pkt_received)
print("Finished sniffing packets.")
