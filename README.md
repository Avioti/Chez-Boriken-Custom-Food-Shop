# **Chez Boriken - A Custom CLI Food Shop**

A commandline restaurant ordering system built with Java that allows customers to create custom meal plates or order pre-built entrees with real-time inventory tracking.

   <img width="721" height="385" alt="image" src="https://github.com/user-attachments/assets/7c225bde-3a0e-470a-abfb-836f7b0c4f2f" />

## Features

### Build Your Own Plate
- Select from mains, sides, and drinks to create custom meals
- Choose from three plate sizes with portion limits (Small, Medium, Large)
- Add optional pineapple bowl for +$2.50
- Modify plate contents before checkout
- Real-time inventory updates as items are added

### Order Pre-Built Entrees
- Browse featured entree combinations
- Edit entree components (main, side, drink, or size)
- Quick ordering for customers who prefer preset options

### Inventory & Order Management
- Real-time stock tracking for all food items
- Automatic inventory reduction when items are ordered
- Prevention of over-ordering when limits are reached
- Detailed receipt creation with order IDs and timestamps

## How It Works

1. **Welcome Screen** - Start here to choose your action:
   - Create a custom plate
   - Order a pre-built entree
   - View Receipts
   - Exit Application

2. **Build or Browse** - Select your plate size or entree and add items to your order

3. **Customize** - Modify plates, change sizes, or edit entree components

4. **Checkout** - Review your order, confirm, and receive your receipt


## Object-Oriented Design

This project demonstrates key OOP principles:
- **Inheritance**: Main, Side, Drink extend Food base class
- **Polymorphism**: Different food types behave differently
- **Encapsulation**: Private fields with public accessors
- **Abstraction**: Complex operations hidden behind simple interfaces
- **Composition**: Orders and plates contain multiple Food objects

## Data Storage

Orders are stored with:
- Order ID (randomly generated)
- Timestamp
- Customer name
- Plate contents and size
- Total price
- Receipt generation for records
