# hackathon-project


👇

🧠 SYSTEM DESIGN OVERVIEW (High-Level)
4
🔄 Flow (Simple Explanation)
User opens React app
Frontend calls backend APIs
Backend processes logic
Data stored in MySQL
Inventory updates pushed in real-time
🏗️ ARCHITECTURE (BLOCK VIEW)
[ React Frontend ]
        ↓
[ API Gateway / Controller Layer ]
        ↓
[ Service Layer (Business Logic) ]
        ↓
[ Repository Layer (JPA) ]
        ↓
[ MySQL Database ]

        ↕ (Real-time)
   [ WebSocket Server ]
🧩 MODULE-WISE DESIGN (TEAM VIEW)
👤 1. AUTH MODULE
Frontend → /api/auth → Backend → DB

Flow

Login/Register → JWT → Stored in frontend
📦 2. PRODUCT + INVENTORY MODULE (CORE 🔥)
Admin updates stock
        ↓
Backend updates DB
        ↓
WebSocket broadcasts update
        ↓
Frontend updates instantly

👉 This is your main highlight feature

🛒 3. CART + ORDER MODULE
Add to Cart → Save in DB
        ↓
Place Order → Deduct Inventory
        ↓
Order stored → Status updated
🎨 4. FRONTEND UI FLOW
Home → Product List → Add to Cart → Checkout → Order Page
🔗 DATABASE DESIGN (SIMPLIFIED)
4
User (1) ──── (N) Order
Order (1) ──── (N) OrderItems
Product (1) ──── (1) Inventory
User (1) ──── (1) Cart
Cart (1) ──── (N) CartItems
📡 API DESIGN (SIMPLE MAP)
AUTH
POST /api/auth/register
POST /api/auth/login

PRODUCT
GET /api/products
GET /api/products/{id}

INVENTORY
GET /api/inventory/{productId}
PUT /api/inventory/update

CART
POST /api/cart/add
GET /api/cart

ORDER
POST /api/orders
GET /api/orders/{userId}
⚡ REAL-TIME INVENTORY DESIGN
Frontend (React)
   ↓ (WebSocket)
Backend (Spring Boot WebSocket)
   ↓
Inventory Service
   ↓
Database

↑ Broadcast updates to all users

👉 Example:

User A buys last item
User B instantly sees “Out of Stock”
🧑‍💻 TEAM UNDERSTANDING (WHO DOES WHAT)
Team Member	Responsibility
Dev 1	Auth + User
Dev 2	Product + Inventory
Dev 3	Cart + Orders
Dev 4	Frontend + Integration
🔁 COMPLETE USER FLOW (END-TO-END)
1. User logs in
2. Fetch products
3. Show inventory status
4. Add to cart
5. Place order
6. Inventory reduced
7. Real-time update to all users
🧠 SIMPLE ANALOGY (FOR YOUR TEAM)

Think like this:

Frontend = Shop UI
Backend = Shop Manager
Database = Store Room
WebSocket = Live Announcement System
⚡ QUICK TEAM EXPLANATION (30-SECOND VERSION)

👉 “We are building a grocery app where users can browse products, add to cart, and order.
Backend handles logic and stores data in MySQL.
The key feature is real-time inventory using WebSockets — when stock changes, all users see updates instantly.”
